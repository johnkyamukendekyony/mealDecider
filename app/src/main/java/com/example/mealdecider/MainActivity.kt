package com.example.mealdecider

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mealdecider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val resetbutton = findViewById<Button>(R.id.resetButton)
        val inputText = findViewById<EditText>(R.id.inputText)
        val outputText = findViewById<TextView>(R.id.outputText)
        val proccessButton = findViewById<Button>(R.id.ProcessButton)

        val dailyMeals = hashMapOf("Morning" to "Eggs" , "Mid-Morning" to "Fruits" , "Afternoon" to "Sandwiches",
            "Mid-afternoon" to "Cake" , "Dinner" to "Pasta" , "Mid-Dinner" to "Desert"
        )


        resetbutton.setOnClickListener{
            inputText.text.clear()
            outputText.text = "Type in the time of day and press process"
        }

        proccessButton.setOnClickListener{
            if(inputText.text.isNotEmpty()){

                val meal = dailyMeals.get(inputText.text.toString())

                if(meal != null){
                    outputText.text = meal
                }else{
                    outputText.text = "Input is not valid"
                }

            }else {
                outputText.text = "Input is empty"
            }
        }


    }
}