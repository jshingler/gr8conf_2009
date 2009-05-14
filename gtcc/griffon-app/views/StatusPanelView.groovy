import net.miginfocom.swing.MigLayout
import java.awt.Color

statusesPanel.add(
    panel(background: Color.white, layout: new MigLayout()) {
      label(icon: imageIcon(resource: model.person.imageName(), class: controller.getClass()))
      label(text: bind{model.message}, constraints: "growx, span, wrap")
      label(text: bind{model.person.username})
      label(text: bind{model.person.userRealName})
      label(text: bind{model.dateCreated}, constraints: "growx ,align right")
    }
)
