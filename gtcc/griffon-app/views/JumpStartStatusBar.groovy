import static javax.swing.BorderFactory.*
import java.awt.GridBagConstraints
import javax.swing.SwingConstants

println "INITIALIZING: JumpStartStatusBar"

jxstatusBar(id: 'statusPanel', border: createEmptyBorder() ) {
    gridBagLayout()
    separator(constraints:gbc(gridwidth:GridBagConstraints.REMAINDER, fill:GridBagConstraints.HORIZONTAL))
    label('Welcome . . . ',
        id: 'status', text: 'Welcome . . .',
        constraints:gbc(weightx:1.0,
            anchor:GridBagConstraints.WEST,
            fill:GridBagConstraints.HORIZONTAL,
            insets: [1,3,1,3])
    )
    label(id: 'status2',
		text: '',
		preferredSize : [50, 10]
    )
}
