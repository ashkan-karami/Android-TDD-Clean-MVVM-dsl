package com.ashkan.userprofile.common.base_domain.model

enum class PositionOfItem {
    DEFAULT,
    MOVED
}

open class MovableAdapterData {
    var position: PositionOfItem = PositionOfItem.DEFAULT
    var lastPosition: PositionOfItem = PositionOfItem.DEFAULT
    var isOpen : Boolean = false

}

fun reversePosition(item: PositionOfItem) : PositionOfItem =
    if(item == PositionOfItem.MOVED) PositionOfItem.DEFAULT else PositionOfItem.MOVED
