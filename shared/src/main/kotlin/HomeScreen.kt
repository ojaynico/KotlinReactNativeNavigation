import ojaynico.kotlin.react.button
import ojaynico.kotlin.react.json
import ojaynico.kotlin.react.native.navigation.Navigation
import ojaynico.kotlin.react.text
import ojaynico.kotlin.react.view
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

interface HomeScreenProps : RProps {
    val componentId: String
}

abstract class HomeScreen : RComponent<HomeScreenProps, RState>() {

    override fun componentDidMount() {

    }

    fun navigationButtonPressed(buttonId: String) {

    }

    override fun RBuilder.render() {
        view {
            attrs.style = styles.root
            text("Hello Kotlin React Native Navigation \uD83D\uDC4B") {}
            button {
                title = "Push Settings Screen"
                color = "#710ce3"
                onPress = {
                    Navigation.push(props.componentId, json {
                        this.component = json {
                            this.name = "SettingsScreen"
                            this.options = json {
                                this.topBar = json {
                                    this.title = json {
                                        this.text = "Settings"
                                        this.color = "white"
                                    }
                                }
                            }
                        }
                    })
                }
            }
        }
    }
}
