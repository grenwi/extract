package org.icij.extract.queue;

import org.icij.extract.document.DocumentFactory;
import org.icij.extract.document.PathIdentifier;
import org.junit.*;

import java.nio.file.Paths;

public class ArrayTikaDocumentQueueTest {

	private final DocumentFactory factory = new DocumentFactory().withIdentifier(new PathIdentifier());

	@Test
	public void testCloseClearsTheQueue() {
		final DocumentQueue queue = new ArrayDocumentQueue(1);

		Assert.assertEquals(0, queue.size());
		queue.add(factory.create(Paths.get("essay.txt")));
		Assert.assertEquals(1, queue.size());

		queue.clear();
		Assert.assertEquals(0, queue.size());
	}
}
