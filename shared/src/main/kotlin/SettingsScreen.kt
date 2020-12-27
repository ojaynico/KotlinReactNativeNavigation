import ojaynico.kotlin.react.text
import ojaynico.kotlin.react.view
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class SettingsScreen : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        view {
            attrs.style = styles.root
            text("Settings Screen") {}
        }
    }
}
