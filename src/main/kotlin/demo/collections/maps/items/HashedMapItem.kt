package demo.collections.maps.items

class HashedMapItem(val value: Int) {

    override fun hashCode(): Int {
        println("hashCode called")
        return value
    }

    override fun equals(other: Any?): Boolean {
        println("equals called")
        return super.equals(other)
    }
}