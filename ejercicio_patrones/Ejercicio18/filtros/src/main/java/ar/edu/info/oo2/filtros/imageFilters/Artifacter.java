package ar.edu.info.oo2.filtros.imageFilters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

public class Artifacter extends Filter {

    // *** CAMBIO CLAVE AQUI ***:
    // La variable estática se inicializa a null, y el archivo temporal se crea
    // de forma dinámica dentro del método filter para garantizar la portabilidad y limpieza.
    public static File tempFile = null;
    public static float compressionQuality = 0.005f;

    public BufferedImage filter(BufferedImage image) {

        // 1. Crear el archivo temporal usando el directorio temporal del sistema operativo
        try {
            // Crea un archivo temporal en la ubicación nativa del sistema (Windows/Linux)
            // con un nombre único para evitar conflictos.
            tempFile = File.createTempFile("artifacter", ".jpg");
            tempFile.deleteOnExit(); // Asegura que el archivo se borre al cerrar la aplicación.
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo temporal:\n" + e);
            return image; // Devuelve la imagen original si falla
        }

        // Change the image to a jpg to satisfy the native image writer
    /*try {
      ImageIO.write(image, "jpg", tempFile);
      image = ImageIO.read(tempFile);
    } catch (IOException exception) {
      System.err.println("Unable to rewrite image as jpg\n" + exception);
    }*/

        // Get the jpeg image writer
        ImageWriter writer = (ImageWriter)ImageIO.getImageWritersByFormatName("jpg").next();

        // Set the compression quality
        ImageWriteParam writerParams = writer.getDefaultWriteParam();
        writerParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        writerParams.setCompressionQuality(Artifacter.compressionQuality);

        // Try/Catch for File IO
        try {
            // Write the file
            FileImageOutputStream output = new FileImageOutputStream(Artifacter.tempFile);
            writer.setOutput(output);
            IIOImage tempImage = new IIOImage(image, null, null);
            writer.write(null, tempImage, writerParams);
            writer.dispose();

            // Read the file
            image = ImageIO.read(Artifacter.tempFile);

            // Borrar el archivo inmediatamente después de leerlo para liberar el disco.
            // Si falla, deleteOnExit() lo borrará al terminar el programa.
            Artifacter.tempFile.delete();

        } catch (IOException exception) {
            System.err.println("Unable to read temp file for artifacter\n" + exception);
        }

        return image;
    }
}
