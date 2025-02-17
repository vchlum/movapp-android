package cz.movapp.app.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cz.movapp.app.R
import cz.movapp.app.databinding.ChildrenItemBinding
import cz.movapp.app.ui.children.ChildrenData

class ChildrenAdapter (
    private val context: Context,
    private val dataset: List<ChildrenData>
): RecyclerView.Adapter<ChildrenAdapter.ItemViewHolder>() {

    var fromUa = true

    class ItemViewHolder(binding: ChildrenItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ChildrenItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        /* for dark theme, use white color as tint */
        when (context.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                holder.binding.imageChildrenMain.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.white))
            }
            else -> {
                holder.binding.imageChildrenMain.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
            }
        }

        holder.binding.apply {
            imageChildrenMain.setImageDrawable(item.image)

            if (fromUa) {
                textChildrenFrom.text = formatTrans(item.translation_from, item.transcription_from)
                textChildrenTo.text = formatTrans(item.translation_to, item.transcription_to)

                imageChildrenFlagFrom.setImageResource(R.drawable.ua)
                imageChildrenFlagTo.setImageResource(R.drawable.cz)
            } else {
                textChildrenFrom.text = formatTrans(item.translation_to, item.transcription_to)
                textChildrenTo.text = formatTrans(item.translation_from, item.transcription_from)

                imageChildrenFlagFrom.setImageResource(R.drawable.cz)
                imageChildrenFlagTo.setImageResource(R.drawable.ua)
            }
        }
    }

    private fun formatTrans(translation: String, transcription: String) : String {
        return "$translation [${transcription}]"
    }
}