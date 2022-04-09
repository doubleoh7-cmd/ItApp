package com.example.itapp

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.itapp.login.ui.login.LoginFragment
import com.example.itapp.ui.Admission.AdmissionFragment
import com.example.itapp.ui.Faculty_StaffDirectory.FacultyFragment
import com.example.itapp.ui.RateUs.RateUsFragment
import com.example.itapp.ui.Socialmedia.SocialMediaFragment
import com.example.itapp.ui.Timetable.TimeTableFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(com.google.android.material.R.id.container, LoginFragment())
                .commit()
        }*/

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_View)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                //R.id.nav_home -> replaceFragment()
                R.id.nav_Faculty -> replaceFragment(FacultyFragment(), it.title.toString())
                R.id.nav_Admissions -> replaceFragment(AdmissionFragment(), it.title.toString())
                R.id.nav_Courses -> replaceFragment(AdmissionFragment(), it.title.toString())
                R.id.nav_Timetable -> replaceFragment(TimeTableFragment(), it.title.toString())
                R.id.nav_SocialMedia -> replaceFragment(SocialMediaFragment(), it.title.toString())
                R.id.nav_rate_us -> replaceFragment(RateUsFragment(), it.title.toString())
                R.id.nav_Logout -> replaceFragment(LoginFragment(), it.title.toString())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frameLayout,fragment)
        fragmentTransition.commit()
        setTitle(title)
        drawerLayout.closeDrawers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}