/*
 * Copyright 2016-2018 Leon Chen
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

package com.moilioncircle.redis.replicator.cmd.parser;

import com.moilioncircle.redis.replicator.cmd.CommandParser;
import com.moilioncircle.redis.replicator.cmd.impl.HSetNxCommand;

import static com.moilioncircle.redis.replicator.cmd.parser.CommandParsers.toBytes;
import static com.moilioncircle.redis.replicator.cmd.parser.CommandParsers.toRune;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class HSetNxParser implements CommandParser<HSetNxCommand> {

    @Override
    public HSetNxCommand parse(Object[] command) {
        int idx = 1;
        String key = toRune(command[idx]);
        byte[] rawKey = toBytes(command[idx]);
        idx++;
        String field = toRune(command[idx]);
        byte[] rawField = toBytes(command[idx]);
        idx++;
        String value = toRune(command[idx]);
        byte[] rawValue = toBytes(command[idx]);
        idx++;
        return new HSetNxCommand(key, field, value, rawKey, rawField, rawValue);
    }

}
