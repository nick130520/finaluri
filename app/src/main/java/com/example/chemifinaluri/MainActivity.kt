package com.example.chemifinaluri



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.chemifinaluri.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        firebaseAuth=FirebaseAuth.getInstance()
        setContentView(binding.root)
        if (firebaseAuth.currentUser!=null) {
            replacefragment(todolist())
            binding.nav.setOnItemReselectedListener {
                when (it.itemId) {
                    R.id.profile -> replacefragment(profile())
                    R.id.todolist -> replacefragment(todolist())
                    else -> {
                    }
                }
            }
        }
        else {
            binding.nav.visibility = View.GONE
            replacefragment(register())
        }
    }
    private fun replacefragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }
}