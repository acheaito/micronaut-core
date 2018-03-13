package io.micronaut.runtime.http.codec

import io.micronaut.core.io.buffer.ByteBuffer
import io.micronaut.core.io.buffer.ByteBufferFactory
import io.micronaut.core.io.buffer.ByteBuffer
import io.micronaut.core.io.buffer.ByteBufferFactory
import spock.lang.Shared
import spock.lang.Specification

import java.nio.charset.StandardCharsets

class TextPlainCodecSpec extends Specification {

    @Shared TextPlainCodec codec = new TextPlainCodec(StandardCharsets.UTF_8)

    void "test the buffer min and max are correct for special characters"() {
        given:
        ByteBufferFactory bufferFactory = Mock(ByteBufferFactory)
        String val = 'é'

        when:
        codec.encode(val, bufferFactory)

        then:
        1 * bufferFactory.buffer(2, 2) >> Stub(ByteBuffer)
    }
}