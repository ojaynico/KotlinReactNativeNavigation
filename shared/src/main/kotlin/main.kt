import ojaynico.kotlin.react.native.navigation.Navigation
import ojaynico.kotlin.react.native.navigation.RNNDrawer

fun main() {
    Navigation.registerComponent("HomeScreen") { HomeScreen::class.js }
    Navigation.registerComponent("MenuDrawer") { RNNDrawer.create(MenuDrawer::class.js) }
    Navigation.registerComponent("SettingsScreen") { SettingsScreen::class.js }
    Navigation.setDefaultOptions(object {
        val statusBar = object {
            val backgroundColor = "#4d089a"
        }
        val topBar = object {
            val title = object {
                    val color = "white"
            }
            val backButton = object {
                    val color = "white"
            }
            val background = object {
                    val color = "#4d089a"
            }
        }
    })
    Navigation.events().registerAppLaunchedListener {
        Navigation.setRoot(object {
            val root = object {
                val stack = object {
                    val children = arrayOf(
                        object {
                            val component = object {
                                val name = "HomeScreen"
                                val options = object {
                                    val topBar = object {
                                        val title = object {
                                            val text = "Home"
                                            val color = "white"
                                        }
                                        val background = object {
                                            val color = "#4d089a"
                                        }
                                        val leftButtons = object {
                                            val id = "sideMenu"
                                            val icon = kotlinext.js.require("./resources/menu.png")
                                        }
                                    }
                                }
                            }
                        }
                    )
                }
            }
        })
    }
    Navigation.events().registerNavigationButtonPressedListener {
        if (it.buttonId == "sideMenu") {
            RNNDrawer.showDrawer(object {
                val component = object {
                    val name = "MenuDrawer"
                    val passProps = object {
                        val animationOpenTime = 300
                        val animationCloseTime = 300
                        val direction = "left"
                        val dismissWhenTouchOutside = true
                        val fadeOpacity = 0.6
                        val drawerScreenWidth = "75%"
                        val drawerScreenHeight = "100%"
                        val style = {
                            val backgroundColor = "red"
                        }
                        val parentComponentId = it.componentId
                    }
                }
            })
        }
    }
}
