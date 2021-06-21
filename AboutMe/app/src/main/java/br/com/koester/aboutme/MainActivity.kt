package br.com.koester.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import br.com.koester.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val myName : MyName = MyName("Anderson Koester")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // FORMA DE REFERENCIAR UM ELEMENTO/VIEW DECLARATIVO
        /*val doneButton : Button = findViewById(R.id.done_button);
        doneButton.setOnClickListener{
            addNickname(doneButton)
        }*/
        // FORMA DE REFERENCIAR UM ELEMENTO/VIEW NÃO DECLARATIVO
        /*findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }*/

        // INSTANCIA O DATABINDING PARA EFETUAR REFERÊNCIAS DE ELEMENTOS/VIEWS
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view : View){
        /*val editText : TextView = findViewById(R.id.nickname_edit)
        val nicknameTextView : TextView = findViewById(R.id.nickname_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE*/

        // UTILIZANDO BINDING PARA ACESSAR OS ELEMENTOS/VIEW
        /*binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE*/

        // UTLIZANDO O APPLY PARA ENCAPSULAR O ESCOPO DE BINDING E FACILITAR A LEGIBILIDADE
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            //nicknameText.text = nicknameEdit.text
            // INVALIDA TODOS OS DADOS DA VIEW PARA PODER ATUALIZAR O LAYOUT
            // FORÇA O REBIND
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Ocultar o teclado
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}