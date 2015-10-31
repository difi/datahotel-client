package no.difi.datahotel.client;

import com.csvreader.CsvReader;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Download<T> implements Iterator<T> {

    private InputStream inputStream;
    private Class<T> cls;

    private CsvReader csvReader;
    private String[] headers;

    Download(InputStream inputStream, Class<T> cls) throws IOException {
        this.inputStream = inputStream;
        this.cls = cls;

        this.csvReader = new CsvReader(inputStream, ';', Charset.forName("UTF-8"));
        this.csvReader.setTextQualifier('"');
        this.csvReader.setEscapeMode(CsvReader.ESCAPE_MODE_BACKSLASH);

        this.csvReader.readHeaders();
        this.headers = this.csvReader.getHeaders();
    }

    @Override
    public boolean hasNext() {
        try {
            if (csvReader.readRecord())
                return true;

            csvReader.close();
            inputStream.close();
        } catch (IOException e) {
            // No action
        }
        return false;
    }

    @Override
    public T next() {
        try {
            T o = cls.newInstance();

            String[] line = csvReader.getValues();
            Map<String, String> values = new HashMap<String, String>();

            for (int i = 0; i < headers.length; i++)
                values.put(headers[i], line[i]);

            BeanUtils.populate(o, values);

            return o;
        } catch (IOException e) {
            // No action
        } catch (ReflectiveOperationException e) {
            // No action
        }
        return null;
    }
}
