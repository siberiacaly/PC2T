public class prumerException extends java.lang.Exception
{
    public prumerException()
    {
        super("Nebyl zadan prumer");
    }
    public prumerException(float prumer)
    {
        super("Prumer nebyl zadan v intervalu 1 az 5. Zadali jste: " + prumer);
    }
}