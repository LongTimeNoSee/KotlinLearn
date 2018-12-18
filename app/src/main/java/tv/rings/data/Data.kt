package tv.rings.data

 class Data {
    var link: String = ""
     get() {
         return field.toUpperCase()
     }

     set(value) {
         field = "name:$value"
     }

}