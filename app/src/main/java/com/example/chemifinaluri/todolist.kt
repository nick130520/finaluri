package com.example.chemifinaluri

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class todolist : Fragment() {
    private var todoList: ListView? = null
    private var addButton: ImageButton? = null
    private var todoData: MutableList<String>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val M = inflater.inflate(R.layout.fragment_todolist, container, false)
        todoList = M.findViewById(R.id.todoList)
        addButton = M.findViewById(R.id.addButton)
        todoData = ArrayList<String>()

        addButton!!.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.edittext, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.ragacaa)
            with(builder) {
                setTitle("Enter new Username")
                setPositiveButton("change") { dialog, which ->
                    val value = editText.text.toString()
                    todoData!!.add(value)
                    val adapter =
                        ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1)
                    adapter.addAll(todoData as List<String>)
                    todoList!!.adapter = adapter
                }
                setNegativeButton("Cancel") { dialog, whichButton ->
                }
                setView(dialogLayout)
                show()
            }
        }
        return M

    }
}
