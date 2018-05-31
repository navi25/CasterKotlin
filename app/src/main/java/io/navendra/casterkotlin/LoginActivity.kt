package io.navendra.casterkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.mobile.auth.core.IdentityHandler
import com.amazonaws.mobile.auth.core.IdentityManager
import com.amazonaws.mobile.auth.ui.SignInUI
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.AWSStartupResult
import com.amazonaws.mobile.client.AWSStartupHandler
import com.amazonaws.mobile.config.AWSConfiguration


class LoginActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = this::class.java.simpleName
    }
    private var credentialsProvider: AWSCredentialsProvider? = null
    private var awsConfiguration: AWSConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        AWSMobileClient.getInstance().initialize(this) {
            credentialsProvider = AWSMobileClient.getInstance().credentialsProvider
            awsConfiguration = AWSMobileClient.getInstance().configuration

            IdentityManager.getDefaultIdentityManager().getUserID(object : IdentityHandler {
                override fun handleError(exception: Exception?) {
                    Log.e(TAG, "Retrieving identity: ${exception}")
                }
                override fun onIdentityId(identityId: String?) {
                    Log.d(TAG, "Identity = $identityId")
                    val cachedIdentityId = IdentityManager.getDefaultIdentityManager().cachedUserID
                    // Do something with the identity here
                }
            })

            val signin = AWSMobileClient.getInstance().getClient(this@LoginActivity, SignInUI::class.java) as SignInUI
            signin.login(this@LoginActivity,MainActivity::class.java).execute()

        }.execute()

        AWSMobileClient.getInstance().initialize(this) {

        }.execute()
    }
}
