package it.unimi.di.law.warc.processors;

/*
 * Copyright (C) 2004-2013 Paolo Boldi, Massimo Santini, and Sebastiano Vigna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// RELEASE-STATUS: DIST

import it.unimi.di.law.warc.processors.ParallelFilteredProcessorRunner.Writer;
import it.unimi.di.law.warc.records.WarcRecord;

import java.io.IOException;
import java.io.PrintStream;

public class ConstantPositionURLWriter implements Writer<WarcRecord> {
	/** A string that will be prepended to each line. */
	private final String constant;

	public ConstantPositionURLWriter(final String constant) {
		this.constant = constant;
	}

	@Override
	public void write(final WarcRecord warcRecord, final long storePosition, final PrintStream out) throws IOException {
		out.print(constant);
		out.print('\t');
		out.print(storePosition);
		out.write('\t');
		out.print(warcRecord.getWarcTargetURI());
		out.write('\n');
	}

	@Override
	public void close() throws IOException {}
}
