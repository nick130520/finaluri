package com.example.chemifinaluri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.chemifinaluri.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class register : Fragment() {
    private lateinit var binding: ActivityMainBinding
    lateinit var signup: Button
    lateinit var texttoin: TextView
    lateinit var emailup: TextInputEditText
    lateinit var passup: TextInputEditText
    lateinit var confirmpass: TextInputEditText
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_register, container, false)
        binding=ActivityMainBinding.inflate(layoutInflater)
        signup=V.findViewById(R.id.signup)
        texttoin=V.findViewById(R.id.texttoin)
        emailup=V.findViewById(R.id.emailup)
        passup=V.findViewById(R.id.passup)
        confirmpass=V.findViewById(R.id.confirmPass)
        firebaseAuth= FirebaseAuth.getInstance()
        texttoin.setOnClickListener {
            shecvla(login())
        }
        signup.setOnClickListener {
            val emailup = emailup.text.toString()
            val passup = passup.text.toString()
            val confirmPass = confirmpass.text.toString()

            if (emailup.isNotEmpty() && passup.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (passup == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(emailup, passup).addOnCompleteListener {
                        if (it.isSuccessful) {
                            shecvla(login())
                        } else {
                            Toast.makeText(requireContext(), it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(requireContext(), "მემარცხენე ხარ?", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "ნუ გეზარება წერა!", Toast.LENGTH_SHORT).show()

            }
        }
        return V

    }
    private fun shecvla(fragment: Fragment){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.framelayout, fragment)
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }


}