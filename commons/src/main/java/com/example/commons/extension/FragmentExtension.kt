package com.example.commons.extension

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class FragmentExtension
fun Fragment.shortToast(msg:String){
    Toast.makeText(context,msg!!, Toast.LENGTH_SHORT).show()
}
fun Fragment.longToast(msg:String){
    Toast.makeText(context,msg!!, Toast.LENGTH_LONG).show()
}
inline fun <reified T : ViewModel> Fragment.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, viewModelFactory)[T::class.java]
}
