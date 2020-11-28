package uk.co.dcfhosting.aboutmeapp

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nicknameEdit: EditText
    lateinit var nickNameTV: TextView
    lateinit var doneButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nicknameEdit = findViewById(R.id.nickname_edit)
        nickNameTV = findViewById(R.id.nickname_text)

        doneButton = findViewById(R.id.done_button)
        doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    fun addNickname(view: View) {
        nickNameTV.text = nicknameEdit.text
        nickNameTV.visibility = View.VISIBLE
        nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}