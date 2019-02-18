import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HtmlFile {

	private Path fileName;

	public HtmlFile(Path fileName)
	{
		this.fileName = fileName;
	}

	public List<String> dateiLesen() throws IOException
	{

		List<String> files = Files.readAllLines(fileName);

		return files;

	}
}
