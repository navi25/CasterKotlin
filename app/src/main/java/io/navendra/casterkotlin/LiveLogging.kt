package io.navendra.casterkotlin

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

data class ClassInfo(
    var TAG:String? = ""
)

open class LiveLogging(classInfo: ClassInfo?) : LifecycleObserver{

    var TAG:String? = classInfo?.TAG

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun listenCreation(){
        Log.d(TAG,"Created!!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun listenPause(){
        Log.d(TAG,"Paused!!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun listenResumed(){
        Log.d(TAG,"Resume!!")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun listenDeletion(){
        Log.d(TAG,"Destroyed!!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun listenAny(){
        Log.d(TAG,"Any!!")
    }
}