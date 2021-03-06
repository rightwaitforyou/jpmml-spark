/*
 * Copyright (c) 2015 Villu Ruusmann
 *
 * This file is part of JPMML-Spark
 *
 * JPMML-Spark is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Spark is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Spark.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.spark;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Row;
import org.jpmml.evaluator.Evaluator;

public class PMMLFunction implements Function<Row, Row> {

	private Evaluator evaluator = null;


	public PMMLFunction(Evaluator evaluator){
		setEvaluator(evaluator);
	}

	@Override
	public Row call(Row row){
		Evaluator evaluator = getEvaluator();

		return EvaluatorUtil.evaluate(evaluator, row);
	}

	public Evaluator getEvaluator(){
		return this.evaluator;
	}

	private void setEvaluator(Evaluator evaluator){
		this.evaluator = evaluator;
	}
}