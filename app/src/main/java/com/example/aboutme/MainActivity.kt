package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //    create a binding object - a layer of glue between a layout and its views and the data specific to the main activity
    private lateinit var binding: ActivityMainBinding
    private val myName : MyName = MyName("kevin Irungu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        we replace the setContentView create the binding object that connects the layout with activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

// set setOnClickListener for the done_button
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }
//        replace findViewById with the binding object. That way we can generate the done_button
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    // we are going to assign the empty text view equal to the text inputted in the edit_nickname field
    private fun addNickname(view: View) {

        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
//        invalidate all binding expressions so that they get updated with new data
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE
//hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}
