package id.lukasdylan.movielicious

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.lukasdylan.movielicious.presentation.home.HomeActivity

/**
 * Created by lukasdylan on 2020-01-31
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}