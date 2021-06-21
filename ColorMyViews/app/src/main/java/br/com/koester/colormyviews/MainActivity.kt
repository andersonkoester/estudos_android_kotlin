package br.com.koester.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.koester.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners(){
        val clickableViews : List<View> = listOf(binding.boxOneText,
                                                binding.boxTwoText,
                                                binding.boxThreeText,
                                                binding.boxFourText,
                                                binding.boxFiveText,
                                                binding.constraintLayout,
                                                binding.redButton,
                                                binding.yelloButton,
                                                binding.greenButton)

        for(item in clickableViews){
            item.setOnClickListener{ makeColored(it) }
        }
    }

    private fun makeColored(view : View){
        when(view.id){
            // BOXES UTILIZANDO A CLASSE COLOR PARA O FUNDO
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            // BOXES UTILIZANDO O ANDROID COLOR PARA O FUNDO
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yello_button -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> binding.boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}