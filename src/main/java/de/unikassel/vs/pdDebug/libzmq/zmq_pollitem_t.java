package de.unikassel.vs.pdDebug.libzmq;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import static de.unikassel.vs.pdDebug.libzmq.LibZMQLibrary.SOCKET;
/**
 * <i>native declaration : zmq.h:107</i><br>
 * This file was autogenerated by <a href="https://github.com/nativelibs4java/JNAerator">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="https://github.com/nativelibs4java">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class zmq_pollitem_t extends Structure {
	/** C type : void* */
	public Pointer socket;
	/** C type : SOCKET */
	public SOCKET fd;
	public short events;
	public short revents;
	public zmq_pollitem_t() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("socket", "fd", "events", "revents");
	}
	/**
	 * @param socket C type : void*<br>
	 * @param fd C type : SOCKET
	 */
	public zmq_pollitem_t(Pointer socket, SOCKET fd, short events, short revents) {
		super();
		this.socket = socket;
		this.fd = fd;
		this.events = events;
		this.revents = revents;
	}
	public zmq_pollitem_t(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends zmq_pollitem_t implements Structure.ByReference {
		
	};
	public static class ByValue extends zmq_pollitem_t implements Structure.ByValue {
		
	};
}
