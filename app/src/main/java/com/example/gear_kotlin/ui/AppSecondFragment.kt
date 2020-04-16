package com.example.gear_kotlin.ui

import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.commons.AppDispatchers
import com.example.commons.BusLiveData
import com.example.commons.extension.williamLog
import com.example.gear_kotlin.base.BaseFragment
import com.example.gear_kotlin.R
import com.example.gear_kotlin.event.EventManager
import com.example.gear_kotlin.event.MessageEvent
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AppSecondFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    @Inject
    lateinit var dispatchers: AppDispatchers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val safeArgs: AppSecondFragmentArgs by navArgs()
        val paramInt = safeArgs.paramInt
        val paramStr = safeArgs.paramStr
        val user = safeArgs.paramObject
        Log.i("AppSecondFragment", "param_int $paramInt");
        Log.i("AppSecondFragment", "param_str $paramStr");
        Log.i("AppSecondFragment", "param_obj ${user!!.name}");
        if (!BusLiveData.br.isClosedForSend)
            BusLiveData.br.offer(20)

        lifecycleScope.launch(dispatchers.main) {
            BusLiveData.br.consumeEach {
                williamLog("AppSecondFragment hanhmai $it")
            }
        }

    }

    @Inject
    lateinit var eventManager: EventManager

    override fun onResume() {
        super.onResume()
        BusLiveData.br.openSubscription()

        val message = Message()
        message.data = bundleOf(
            Pair("arg1", "Arg1 From App Second Fragment"),
            Pair("arg2", "Arg 2 From App Second Fragment")
        )
        eventManager.post(MessageEvent(MessageEvent.REQUEST_MOOD_RATING_DONE, message))
    }

    override fun onPause() {
        super.onPause()
        BusLiveData.br.close()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
