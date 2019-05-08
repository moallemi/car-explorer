package me.moallemi.sixt.ui.browse.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.moallemi.sixt.R
import me.moallemi.sixt.domain.model.Car
import me.moallemi.sixt.extension.load

class CarListAdapter(private val items: List<Car>) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car_item, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = items[position]
        holder.bind(car)
    }

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val modelName = itemView.findViewById<TextView>(R.id.modelName)
        private val image = itemView.findViewById<ImageView>(R.id.image)

        fun bind(car: Car) {
            modelName.text = car.modelName
            image.load(car.carImageUrl, R.drawable.ic_directions_car_black_24dp)
        }
    }
}