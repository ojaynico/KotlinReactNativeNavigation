import ojaynico.kotlin.react.text
import ojaynico.kotlin.react.view
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class MenuDrawer : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        view {
            attrs.style = object {
                val backgroundColor = "red"
            }
            for (i in 0..2) {
                text("Menu $i") {}
            }
        }
    }

}
