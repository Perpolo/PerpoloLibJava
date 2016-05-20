package perpolo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log
{
	public static final String OUT_DIR = "out";
	public static final String FILE_EXTENSION = ".txt";

	private static final String FLD_DEBUG = "-agentlib:jdwp";

	private static final String MSG_FILE_WASNT_CREATED = "file 'out' wasn't created";
	private static final String MSG_EXCEPTION_IS_NULL = "Exception is null";

	private static final String CHR_FLOOR = "_";
	private static final String CHR_COLON_SPACE = ": ";

	private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
	private static final SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

	public static void initLogerToFile()
	{
		try
		{
			File outDir = new File(OUT_DIR);
			if (!outDir.exists())
				outDir.mkdir();

			File outFile = new File(
					outDir.getPath() + File.separator + OUT_DIR + CHR_FLOOR + getDate() + FILE_EXTENSION);

			PrintStream out = new PrintStream(outFile);
			System.setOut(out);
			System.setErr(out);

		} catch (FileNotFoundException e)
		{
			err(MSG_FILE_WASNT_CREATED);
		}
	}

	public static void msg(String msg)
	{
		printOut(msg);
	}

	public static void info(String info)
	{
		printOut(info);
	}

	public static void debug(String debug)
	{
		if (isDebug())
			printOut(debug);
	}

	public static void err(String err)
	{
		printErr(err);
	}

	public static void err(Exception e)
	{
		if (e != null)
			err(e.getMessage());
		else
			err(MSG_EXCEPTION_IS_NULL);
	}

	public static void err(String err, Exception e)
	{
		if (e != null)
			err(err + CHR_COLON_SPACE + e.getMessage());
		else
			err(err);
	}

	private static void printOut(String out)
	{
		System.out.println(getTime() + CHR_COLON_SPACE + out);
	}

	private static void printErr(String err)
	{
		System.err.println(getTime() + CHR_COLON_SPACE + err);
	}

	private static String getTime()
	{
		return String.valueOf(timeFormat.format(new Date()));
	}

	private static String getDate()
	{
		return String.valueOf(dateFormate.format(new Date()));
	}

	private static boolean isDebug()
	{
		return java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString()
				.indexOf(FLD_DEBUG) > 0;
	}
}
