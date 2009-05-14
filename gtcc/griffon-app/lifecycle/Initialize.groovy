/*
 * This script is executed inside the EDT, so be sure to
 * call long running code in another thread.
 *
 * You have the following options
 * - SwingBuilder.doOutside { // your code  }
 * - Thread.start { // your code }
 * - SwingXBuilder.withWorker( start: true ) {
 *      onInit { // initialization (optional, runs in current thread) }
 *      work { // your code }
 *      onDone { // finish (runs inside EDT) }
 *   }
 *
 * You have the following options to run code again inside EDT
 * - SwingBuilder.doLater { // your code }
 * - SwingBuilder.edt { // your code }
 * - SwingUtilities.invokeLater { // your code }
 */

import groovy.swing.SwingBuilder
import griffon.util.GriffonPlatformHelper

GriffonPlatformHelper.tweakForNativePlatform(app)
//SwingBuilder.lookAndFeel('net.sourceforge.napkinlaf.NapkinLookAndFeel', 'nimbus', 'mac', 'gtk', ['metal', [boldFonts: false]])
SwingBuilder.lookAndFeel('nimbus', 'mac', 'gtk', ['metal', [boldFonts: false]])

def splashScreen = SplashScreen.getInstance()

// Setting a splash image
//URL url = this.class.getResource("mySplash.jpg")
//splashScreen.setImage(url)
//
// Setting Status Text
// SplashScreen.getInstance().showStatus("Initializing the Controller")
splashScreen.splash()
splashScreen.waitForSplash()



GtccController.metaClass.mixin JumpStartMixin
ResourceUtils.setBundlePath("Resource.properties")
GtccView.metaClass.mixin JumpStartViewMixin
      