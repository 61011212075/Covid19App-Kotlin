package com.example.android.covid19app.adapter



import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.covid19app.R
import com.example.android.covid19app.services.model.ProvinceInfection
import java.text.DecimalFormat

class ProvinceAdapter(private val province: List<ProvinceInfection>): RecyclerView.Adapter<ProvinceAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val bindingProvince: TextView = view.findViewById(R.id.province)
        val bindingNewCase: TextView = view.findViewById(R.id.new_cases)
        val bindingDeath: TextView = view.findViewById(R.id.death)
        val cardDeath: CardView = view.findViewById(R.id.card_death)
        val cardNewCases: CardView = view.findViewById(R.id.card_new_cases)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.province_list_item,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Formant Number
        val dec = DecimalFormat("#,###.##")

        // Check new cases
        holder.bindingProvince.text = province[position].province
        if(province[position].newCase < 1){
            holder.cardNewCases.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            holder.cardNewCases.cardElevation = 0F
        }else{
            holder.bindingNewCase.text = "+${dec.format(province[position].newCase)}"
            holder.cardNewCases.setCardBackgroundColor(Color.parseColor("#FB9900"))
        }

        // Check new death
        if(province[position].newDeath < 1){
            holder.cardDeath.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            holder.cardDeath.cardElevation = 0F
        }else{
            holder.bindingDeath.text = "+${dec.format(province[position].newDeath)}"
            holder.cardDeath.setCardBackgroundColor(Color.parseColor("#EF4937"))
        }

    }

    override fun getItemCount(): Int = province.size - 1

}