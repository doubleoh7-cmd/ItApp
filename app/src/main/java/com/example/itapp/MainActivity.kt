package com.example.itapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.UserHandle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.itapp.databinding.ActivityMainBinding
import com.example.itapp.ui.Admissions.AdmissionFragment
import com.example.itapp.ui.Course.CourseFragment
import com.example.itapp.ui.Faculty_StaffDirectory.FacultyFragment
import com.example.itapp.ui.RateUs.RateUsFragment
import com.example.itapp.ui.Socialmedia.SocialMediaFragment
import com.example.itapp.ui.Timetable.TimeTableFragment
import com.example.itapp.ui.home.HomeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private var backPressedTime = 0L
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fab : FloatingActionButton = findViewById(R.id.fab)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_View)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        replaceFragment(HomeFragment(), "Home")

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment(), it.title.toString())
                R.id.nav_Faculty -> replaceFragment(FacultyFragment(), it.title.toString())
                R.id.nav_Admissions -> replaceFragment(AdmissionFragment(), it.title.toString())
                R.id.nav_Courses -> replaceFragment(CourseFragment(), it.title.toString())
                R.id.nav_Timetable -> replaceFragment(TimeTableFragment(), it.title.toString())
                R.id.nav_SocialMedia -> replaceFragment(SocialMediaFragment(), it.title.toString())
                R.id.nav_rate_us -> replaceFragment(RateUsFragment(), it.title.toString())
                R.id.nav_Logout -> startActivity(Signin())
            }
            true
        }

        fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "ithod@ucc.edu.jm", null))
            startActivity(intent)
        }

    }

    private fun startActivity(activity: AppCompatActivity){
        Firebase.auth.signOut()
        finish()
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
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

    override fun onBackPressed() { //Back button to exit app
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            Toast.makeText(applicationContext, "press back again to exit app", Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}