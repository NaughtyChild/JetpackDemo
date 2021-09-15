package com.naughtychild.jetpack.util

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.ContextCompat
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*

/**
 *改变文本颜色或字体大小。字体单位是dp。
 */
class SpanBuilder(content: String) {
    private var spannableString: SpannableStringBuilder = SpannableStringBuilder(content)

    fun color(context: Context,start: Int,end: Int,colorRes: Int): SpanBuilder {
        val colorSpan = ForegroundColorSpan(ContextCompat.getColor(context,colorRes))
        spannableString.setSpan(colorSpan,start,end,Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        return this
    }
    fun bgColor(context: Context,start: Int,end: Int,colorRes: Int): SpanBuilder {
        val colorSpan = BackgroundColorSpan(ContextCompat.getColor(context,colorRes))
        spannableString.setSpan(colorSpan,start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return this
    }

    fun size(start:Int,end :Int,dpSize: Int): SpanBuilder {
        val s = AbsoluteSizeSpan(dpSize,true)
        spannableString.setSpan(s,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return this
    }

    fun bold(start:Int,end :Int,isBold:Boolean = true): SpanBuilder {
        val s = if (isBold) StyleSpan( Typeface.BOLD ) else StyleSpan( Typeface.NORMAL)
        spannableString.setSpan(s,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return this
    }

    fun clickSpan(start: Int, end: Int, clickableSpan: ClickableSpan): SpanBuilder {
        spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        return this
    }

    fun build() : SpannableStringBuilder{
        return spannableString
    }
}