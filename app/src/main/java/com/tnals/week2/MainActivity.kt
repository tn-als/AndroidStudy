package com.tnals.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tnals.week2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFirstFragment()
        clickBottomNavigation()
    }

    private fun setFirstFragment() {
        binding.bnvHome.selectedItemId = binding.bnvHome.menu.getItem(1).itemId
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        val data = intent.getParcelableExtra<User>("user_data")
        if (currentFragment == null) {
            giveUserData(data, MainFragment())
        }
    }

    private fun clickBottomNavigation() {
        binding.bnvHome.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    val fragment: MainFragment =
                        supportFragmentManager.findFragmentById(R.id.fcv_home) as MainFragment
                    fragment.scrollToTop()
                }
            }
        }
        binding.bnvHome.setOnItemSelectedListener {
            val data = intent.getParcelableExtra<User>("user_data")
            when (it.itemId) {
                R.id.menu_message -> {
                    replaceFragment(MessageFragment())
                    true
                }

                R.id.menu_home -> {
                    giveUserData(data, MainFragment())
                    true
                }

                R.id.menu_profile -> {
                    giveUserData(data, MyPageFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fcv_home, fragment).commit()
    }

    private fun giveUserData(data: User?, fragment: Fragment) {
        if (data != null) {
            val args = Bundle()
            args.putParcelable("user_data", data)
            fragment.arguments = args
            replaceFragment(fragment)
        }
    }
}