package com.example.dynamicviewmposv2

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dynamicviewmposv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val payModeSpinner = binding.paymodeSpinner
        val textInputLayout = binding.textInputLayout3

        viewModel.selectItem.observe(this) {
            val payModeSpinnerLayoutParams =
                payModeSpinner.layoutParams as ConstraintLayout.LayoutParams
            val textInputLayoutParams =
                textInputLayout.layoutParams as ConstraintLayout.LayoutParams
            if (it == 1) {
                payModeSpinnerLayoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                payModeSpinnerLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                payModeSpinnerLayoutParams.endToStart = textInputLayout.id
                payModeSpinnerLayoutParams.endToEnd = ConstraintLayout.LayoutParams.UNSET

                textInputLayoutParams.startToStart = ConstraintLayout.LayoutParams.UNSET
                textInputLayoutParams.startToEnd = payModeSpinner.id
                textInputLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                textInputLayoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                textInputLayout.isEnabled = true
            } else {
                payModeSpinnerLayoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                payModeSpinnerLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                payModeSpinnerLayoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                payModeSpinnerLayoutParams.endToStart = ConstraintLayout.LayoutParams.UNSET

                textInputLayoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                textInputLayoutParams.startToEnd = ConstraintLayout.LayoutParams.UNSET
                textInputLayoutParams.topToTop = ConstraintLayout.LayoutParams.UNSET
                textInputLayoutParams.topToBottom = payModeSpinner.id
                textInputLayoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            }
            payModeSpinner.layoutParams = payModeSpinnerLayoutParams
            textInputLayout.layoutParams = textInputLayoutParams
        }

        setContentView(binding.root)

    }
}