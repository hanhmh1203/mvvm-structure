GEAR BY KOTLIN AND MVVM
=======================
# structure:
![Image of structure](/images/modules.png)

![Image of structure](/images/structure.PNG)

### buildSrc:
```
 Gradle Dependency Management 
 1. Create a root level directory called buildSrc
 2. Inside buildSrc create the file build.gradle.kts and enable the kotlin-dsl plugin with the snippet in build.gradle.kts.
 3. Create file Dependencies.kt for define libraries
```
* [build.gradle.kts](/buildSrc/build.gradle.kts)
* [Dependencies.kt](/buildSrc/src/main/kotlin/Dependencies.kt)

### model:
```
Include all entities in project
```

### local:
```
Implement Room to management database.
```

### remote:
```
Implement Retrofit to get data from api
```

### repository:
```
1. Handle get data from api and save in database.
2. Expose data result
```
```
1. Wrapper get data from local database and get data from api.
2. Data result always in object Resource
3. We can force always load from network or local. 
```
###### example in [UserGitRepositoryImpl](repository/src/main/java/com/example/repository/UserGitRepositoryImpl.kt)
### common:
```
1. Util class.
2. Base class.
3. views need to re-use (dialog..)
4. Extension 
```
### app:
```
Main module. 
1. AndroidManifes.xml
2. Activities, Fragment, Viewmodel.
3. layout
4. Dependency injection.
5. Use case class.
```
# Technical in used
##### Dependency injection: [Dagger](https://github.com/google/dagger)
```
AppComponent: with 2 modules: AppModule::class, ActivityProvider::class
  1. AppModule: with modules network, database, repository, viewModel
  2. ActivityProvider: provide activities, FragmentProvider.
```

##### [Databinding](https://developer.android.com/topic/libraries/data-binding)
```
1. Binding data from viewmodel to layout with two ways.
2. handle action to view (click, input text) 
```
```
add this code into root of view fragment.
    <data>
        <variable
            name="viewModel"
            type="com.example.gear_kotlin.viewmodel.ThirdFragmentViewModel" />
    </data>
- One class _fragmentName_Binding will automatic create.
Example is: ThirdFragmentBinding
```
```
And in Fragment: thirdFragmentBinding.viewModel = viewModel
```
###### Example: [ThirdFragment](app/src/main/java/com/example/gear_kotlin/ui/ThirdFragment.kt) and layout: [fragment_third](/app/src/main/res/layout/fragment_third.xml)


#### [Navigation graph](https://developer.android.com/guide/navigation/navigation-getting-started) and [safe-args](https://developer.android.com/guide/navigation/navigation-pass-data)
```
File location: res/navigation
1 activity has 1 nav_graph.
```
###### Example: [app_nav_graph](/app/src/main/res/navigation/app_nav_graph.xml)
#### [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

![Image of ViewModel LifeCycle](/images/viewmodel-lifecycle.png)
```
- ViewModel never keep context of view (fragment, activity)
- ViewModel init by owner scope (fragment, activity) and ViewModelFactory. 
- Using LiveData to expose to Views (Fragment, Activity)
```
```
init 1 ViewModel in fragment:
1. Add DI to ViewModelModule
2.
@Inject
lateinit var viewModelFactory: ViewModelProvider.Factory
3. in onViewCreated()
   viewModel = getViewModel(viewModelFactory)
```

#### LiveData
```

```
#### ROOM in module: [local](local)
![AppDatabase](/images/AppDatabase.png)
```
When we want to create 1 table we need to:
1. Create 1 file Entity
2. add class entity to AppDatabase
3. Create abstract class DAO
```
```
DAO object 
return 2 type:
1. suspend function: always use ( I will explain suspend function in Coroutines)
2. normal function return type Flow: this is new in coroutines, I have not implement yet.
```
###### Example: [UserGitDao](local/src/main/java/com/example/local/dao/UserGitDao.kt)

#### Retrofit in module: [remote](remote)
```
Define api in class api.
Define function call api in DataSource
```
###### example call an api in viewmodel
```
  private fun getUsers(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
        withContext(dispatchers.io) {
            usersSource = getTopUsersUseCase()
        }
        _users.addSource(usersSource) {
            _users.value = it
        }
    }
```