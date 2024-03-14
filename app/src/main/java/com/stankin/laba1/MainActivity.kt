package com.stankin.laba1

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.stankin.laba1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val selectOne: RadioGroup = findViewById(R.id.select_mark_1)
        val selectTwo: RadioGroup = findViewById(R.id.select_mark_2)
        val selectThree: RadioGroup = findViewById(R.id.select_mark_3)

        selectOne.setOnCheckedChangeListener(this::onSelectListener)
        selectTwo.setOnCheckedChangeListener(this::onSelectListener)
        selectThree.setOnCheckedChangeListener(this::onSelectListener)

        binding.fab.setOnClickListener { view ->
            selectOne.setOnCheckedChangeListener(null);
            selectOne.clearCheck()
            selectOne.setOnCheckedChangeListener(this::onSelectListener)

            selectTwo.setOnCheckedChangeListener(null);
            selectTwo.clearCheck()
            selectTwo.setOnCheckedChangeListener(this::onSelectListener)

            selectThree.setOnCheckedChangeListener(null);
            selectThree.clearCheck()
            selectThree.setOnCheckedChangeListener(this::onSelectListener)

            Snackbar.make(binding.root, "Очищено!", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun onSelectListener (group: RadioGroup, checkedId: Int) {
        val checked: RadioButton = findViewById(checkedId)

        Snackbar
            .make(binding.root, "Вы выбрали значение " + checked.text, Snackbar.LENGTH_LONG)
            .show()
    }
}