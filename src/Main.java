import perpolo.Log;

public class Main
{
	public static void main(String[] args)
	{
		Log.initLogerToFile();

		boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString()
				.indexOf("-agentlib:jdwp") > 0;

		System.out.println(isDebug);

		Exception e = null;
u
		Log.msg("helo!?");
		Log.err("ziomizom!");
		Log.info("");sad
		Log.debug("debag dziala");

		Log.msg("helo!?");
		Log.err(e);
		Log.err("nie dziala bolek", e);

		Log.info("");sdf
		////uuudwLedasdasdsadsfsdrwfsdsdfetyerterog.debsdfsdfug("");

	}
}
