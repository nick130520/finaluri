package com.example.chemifinaluri

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.auth.FirebaseAuth


class profile : Fragment() {
    lateinit var username:TextView
    lateinit var Logout:TextView
    lateinit var changepass:TextView
    lateinit var emailshow:TextView
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val B = inflater.inflate(R.layout.fragment_profile, container, false)
        firebaseAuth=FirebaseAuth.getInstance()
        Logout=B.findViewById(R.id.Logout)
        emailshow=B.findViewById(R.id.emailshow)
        emailshow.text=firebaseAuth.currentUser?.email.toString()
        Logout.setOnClickListener {
            firebaseAuth.signOut()
            Toast.makeText(requireContext(), "Logged out", Toast.LENGTH_SHORT).show()
            activity?.recreate()
        }

        return B

    }
}