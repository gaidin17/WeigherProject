package app.utils.port.decoding.algorithm;

/**
 * Created by Evgeny_Akulenko on 11/14/2017.
 */
public interface Algorithm<T, V> {
	T calculate(V v);
}
