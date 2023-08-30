import com.formdev.flatlaf.FlatIntelliJLaf;

public class BMSTheme
	extends FlatIntelliJLaf
{
	public static final String NAME = "BMSTheme";

	public static boolean setup() {
		return setup( new BMSTheme() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, BMSTheme.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
