package app.utils.port.decoding;

/**
 * Created by Evgeny_Akulenko on 11/14/2017.
 */
public interface Decoder<T, V> {
	T decode(V t);
}
