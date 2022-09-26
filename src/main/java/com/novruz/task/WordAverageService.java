package com.novruz.task;

import com.novruz.task.domain.Response;
import com.novruz.task.domain.VowelProps;
import java.util.List;

public interface WordAverageService {

    Response<List<VowelProps>> doTask(String sentence);
}
