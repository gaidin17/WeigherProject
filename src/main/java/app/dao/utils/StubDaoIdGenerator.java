package app.dao.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Evgeny_Akulenko on 11/22/2017.
 */
@Component
@Scope("prototype")
public class StubDaoIdGenerator {
	private volatile AtomicLong count = new AtomicLong(0);

	public long getNextId() {
		return count.getAndIncrement();
	}
}
