package de.unikassel.vs.pdDebug.libzmq;
import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.ochafik.lang.jnaerator.runtime.NativeSizeByReference;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
/**
 * JNA Wrapper for library <b>LibZMQ</b><br>
 * This file was autogenerated by <a href="https://github.com/nativelibs4java/JNAerator">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="https://github.com/nativelibs4java">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
@SuppressWarnings({"unused", "javadoc"})
public interface LibZMQLibrary extends Library {
	String JNA_LIBRARY_NAME = "libzmq";
	NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(LibZMQLibrary.JNA_LIBRARY_NAME);
	LibZMQLibrary INSTANCE = Native.load(LibZMQLibrary.JNA_LIBRARY_NAME, LibZMQLibrary.class);
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_VERSION_MAJOR = 4;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_VERSION_MINOR = 3;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_VERSION_PATCH = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_VERSION = (4) * 10000 + (3) * 100 + (2);
	/** <i>native declaration : zmq.h</i> */
	int _WIN32_WINNT = 0x0600;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_DEFINED_STDINT = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_HAUSNUMERO = 156384712;
	/** <i>native declaration : zmq.h</i> */
	int EFSM = 156384712 + 51;
	/** <i>native declaration : zmq.h</i> */
	int ENOCOMPATPROTO = 156384712 + 52;
	/** <i>native declaration : zmq.h</i> */
	int ETERM = 156384712 + 53;
	/** <i>native declaration : zmq.h</i> */
	int EMTHREAD = 156384712 + 54;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IO_THREADS = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MAX_SOCKETS = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SOCKET_LIMIT = 3;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_THREAD_PRIORITY = 3;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_THREAD_SCHED_POLICY = 4;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MAX_MSGSZ = 5;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MSG_T_SIZE = 6;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_THREAD_AFFINITY_CPU_ADD = 7;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_THREAD_AFFINITY_CPU_REMOVE = 8;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_THREAD_NAME_PREFIX = 9;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IO_THREADS_DFLT = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MAX_SOCKETS_DFLT = 1023;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_THREAD_PRIORITY_DFLT = -1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_THREAD_SCHED_POLICY_DFLT = -1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PAIR = 0;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PUB = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SUB = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_REQ = 3;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_REP = 4;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_DEALER = 5;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_ROUTER = 6;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PULL = 7;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PUSH = 8;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XPUB = 9;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XSUB = 10;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_STREAM = 11;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XREQ = 5;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XREP = 6;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_AFFINITY = 4;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_ROUTING_ID = 5;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SUBSCRIBE = 6;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_UNSUBSCRIBE = 7;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_RATE = 8;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_RECOVERY_IVL = 9;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SNDBUF = 11;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_RCVBUF = 12;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_RCVMORE = 13;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_FD = 14;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENTS = 15;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_TYPE = 16;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_LINGER = 17;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_RECONNECT_IVL = 18;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_BACKLOG = 19;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_RECONNECT_IVL_MAX = 21;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MAXMSGSIZE = 22;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SNDHWM = 23;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_RCVHWM = 24;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MULTICAST_HOPS = 25;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_RCVTIMEO = 27;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SNDTIMEO = 28;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_LAST_ENDPOINT = 32;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_ROUTER_MANDATORY = 33;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_TCP_KEEPALIVE = 34;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_TCP_KEEPALIVE_CNT = 35;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_TCP_KEEPALIVE_IDLE = 36;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_TCP_KEEPALIVE_INTVL = 37;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IMMEDIATE = 39;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XPUB_VERBOSE = 40;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_ROUTER_RAW = 41;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IPV6 = 42;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MECHANISM = 43;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PLAIN_SERVER = 44;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PLAIN_USERNAME = 45;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PLAIN_PASSWORD = 46;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CURVE_SERVER = 47;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CURVE_PUBLICKEY = 48;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CURVE_SECRETKEY = 49;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CURVE_SERVERKEY = 50;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROBE_ROUTER = 51;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_REQ_CORRELATE = 52;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_REQ_RELAXED = 53;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CONFLATE = 54;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_ZAP_DOMAIN = 55;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_ROUTER_HANDOVER = 56;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_TOS = 57;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CONNECT_ROUTING_ID = 61;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_SERVER = 62;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_PRINCIPAL = 63;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_SERVICE_PRINCIPAL = 64;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_PLAINTEXT = 65;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_HANDSHAKE_IVL = 66;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SOCKS_PROXY = 68;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XPUB_NODROP = 69;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_BLOCKY = 70;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XPUB_MANUAL = 71;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XPUB_WELCOME_MSG = 72;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_STREAM_NOTIFY = 73;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_INVERT_MATCHING = 74;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_HEARTBEAT_IVL = 75;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_HEARTBEAT_TTL = 76;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_HEARTBEAT_TIMEOUT = 77;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_XPUB_VERBOSER = 78;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CONNECT_TIMEOUT = 79;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_TCP_MAXRT = 80;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_THREAD_SAFE = 81;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MULTICAST_MAXTPDU = 84;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_VMCI_BUFFER_SIZE = 85;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_VMCI_BUFFER_MIN_SIZE = 86;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_VMCI_BUFFER_MAX_SIZE = 87;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_VMCI_CONNECT_TIMEOUT = 88;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_USE_FD = 89;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_PRINCIPAL_NAMETYPE = 90;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_SERVICE_PRINCIPAL_NAMETYPE = 91;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_BINDTODEVICE = 92;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_MORE = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SHARED = 3;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_DONTWAIT = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SNDMORE = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_NULL = 0;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PLAIN = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CURVE = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI = 3;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GROUP_MAX_LENGTH = 15;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IDENTITY = 5;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_CONNECT_RID = 61;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_TCP_ACCEPT_FILTER = 38;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IPC_FILTER_PID = 58;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IPC_FILTER_UID = 59;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IPC_FILTER_GID = 60;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_IPV4ONLY = 31;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_DELAY_ATTACH_ON_CONNECT = 39;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_NOBLOCK = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_FAIL_UNROUTABLE = 33;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_ROUTER_BEHAVIOR = 33;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_SRCFD = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_NT_HOSTBASED = 0;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_NT_USER_NAME = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_GSSAPI_NT_KRB5_PRINCIPAL = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_CONNECTED = 0x0001;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_CONNECT_DELAYED = 0x0002;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_CONNECT_RETRIED = 0x0004;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_LISTENING = 0x0008;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_BIND_FAILED = 0x0010;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_ACCEPTED = 0x0020;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_ACCEPT_FAILED = 0x0040;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_CLOSED = 0x0080;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_CLOSE_FAILED = 0x0100;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_DISCONNECTED = 0x0200;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_MONITOR_STOPPED = 0x0400;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_ALL = 0xFFFF;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_HANDSHAKE_FAILED_NO_DETAIL = 0x0800;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_HANDSHAKE_SUCCEEDED = 0x1000;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_HANDSHAKE_FAILED_PROTOCOL = 0x2000;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_EVENT_HANDSHAKE_FAILED_AUTH = 0x4000;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_UNSPECIFIED = 0x10000000;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_UNEXPECTED_COMMAND = 0x10000001;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_INVALID_SEQUENCE = 0x10000002;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_KEY_EXCHANGE = 0x10000003;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_UNSPECIFIED = 0x10000011;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_MESSAGE = 0x10000012;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_HELLO = 0x10000013;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_INITIATE = 0x10000014;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_ERROR = 0x10000015;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_READY = 0x10000016;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_WELCOME = 0x10000017;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_INVALID_METADATA = 0x10000018;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_CRYPTOGRAPHIC = 0x11000001;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZMTP_MECHANISM_MISMATCH = 0x11000002;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZAP_UNSPECIFIED = 0x20000000;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZAP_MALFORMED_REPLY = 0x20000001;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZAP_BAD_REQUEST_ID = 0x20000002;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZAP_BAD_VERSION = 0x20000003;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZAP_INVALID_STATUS_CODE = 0x20000004;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_PROTOCOL_ERROR_ZAP_INVALID_METADATA = 0x20000005;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_POLLIN = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_POLLOUT = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_POLLERR = 4;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_POLLPRI = 8;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_POLLITEMS_DFLT = 16;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_HAS_CAPABILITIES = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_STREAMER = 1;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_FORWARDER = 2;
	/** <i>native declaration : zmq.h</i> */
	int ZMQ_QUEUE = 3;
	/** <i>native declaration : zmq.h:45</i> */
	interface zmq_free_fn extends Callback {
		void apply(Pointer data_, Pointer hint_);
	}

	/**
	 * /<br>
	 * <i>native declaration : zmq.h:172</i>
	 */
	interface zmq_timer_fn extends Callback {
		void apply(int timer_id, Pointer arg);
	}

	/** <i>native declaration : zmq.h:209</i> */
	interface zmq_thread_fn extends Callback {
		void apply(Pointer voidPtr1);
	}

	/**
	 * application that uses different CRT library.<br>
	 * Original signature : <code>int zmq_errno()</code><br>
	 * <i>native declaration : zmq.h:4</i>
	 */
	int zmq_errno();
	/**
	 * Resolves system errors and 0MQ errors to human-readable string.<br>
	 * Original signature : <code>char* zmq_strerror(int)</code><br>
	 * <i>native declaration : zmq.h:9</i>
	 */
	Pointer zmq_strerror(int errnum_);
	/**
	 * Run-time API version detection<br>
	 * Original signature : <code>void zmq_version(int*, int*, int*)</code><br>
	 * <i>native declaration : zmq.h:14</i><br>
	 * @deprecated use the safer methods {@link #zmq_version(IntBuffer, IntBuffer, IntBuffer)} and {@link #zmq_version(IntByReference, IntByReference, IntByReference)} instead
	 */
	@Deprecated
	void zmq_version(IntByReference major_, IntByReference minor_, IntByReference patch_);
	/**
	 * Run-time API version detection<br>
	 * Original signature : <code>void zmq_version(int*, int*, int*)</code><br>
	 * <i>native declaration : zmq.h:14</i>
	 */
	void zmq_version(IntBuffer major_, IntBuffer minor_, IntBuffer patch_);
	/**
	 * Default for new contexts<br>
	 * Original signature : <code>void* zmq_ctx_new()</code><br>
	 * <i>native declaration : zmq.h:19</i>
	 */
	Pointer zmq_ctx_new();
	/**
	 * Original signature : <code>int zmq_ctx_term(void*)</code><br>
	 * <i>native declaration : zmq.h:21</i>
	 */
	int zmq_ctx_term(Pointer context_);
	/**
	 * Original signature : <code>int zmq_ctx_shutdown(void*)</code><br>
	 * <i>native declaration : zmq.h:23</i>
	 */
	int zmq_ctx_shutdown(Pointer context_);
	/**
	 * Original signature : <code>int zmq_ctx_set(void*, int, int)</code><br>
	 * <i>native declaration : zmq.h:25</i>
	 */
	int zmq_ctx_set(Pointer context_, int option_, int optval_);
	/**
	 * Original signature : <code>int zmq_ctx_get(void*, int)</code><br>
	 * <i>native declaration : zmq.h:27</i>
	 */
	int zmq_ctx_get(Pointer context_, int option_);
	/**
	 * Old (legacy) API<br>
	 * Original signature : <code>void* zmq_init(int)</code><br>
	 * <i>native declaration : zmq.h:32</i>
	 */
	Pointer zmq_init(int io_threads_);
	/**
	 * Original signature : <code>int zmq_term(void*)</code><br>
	 * <i>native declaration : zmq.h:34</i>
	 */
	int zmq_term(Pointer context_);
	/**
	 * Original signature : <code>int zmq_ctx_destroy(void*)</code><br>
	 * <i>native declaration : zmq.h:36</i>
	 */
	int zmq_ctx_destroy(Pointer context_);
	/**
	 * Original signature : <code>int zmq_msg_init(zmq_msg_t*)</code><br>
	 * <i>native declaration : zmq.h:47</i>
	 */
	int zmq_msg_init(zmq_msg_t msg_);
	/**
	 * Original signature : <code>int zmq_msg_init_size(zmq_msg_t*, size_t)</code><br>
	 * <i>native declaration : zmq.h:49</i>
	 */
	int zmq_msg_init_size(zmq_msg_t msg_, NativeSize size_);
	/**
	 * Original signature : <code>int zmq_msg_init_data(zmq_msg_t*, void*, size_t, zmq_free_fn*, void*)</code><br>
	 * <i>native declaration : zmq.h:51</i>
	 */
	int zmq_msg_init_data(zmq_msg_t msg_, Pointer data_, NativeSize size_, zmq_free_fn ffn_, Pointer hint_);
	/**
	 * Original signature : <code>int zmq_msg_send(zmq_msg_t*, void*, int)</code><br>
	 * <i>native declaration : zmq.h:53</i>
	 */
	int zmq_msg_send(zmq_msg_t msg_, Pointer s_, int flags_);
	/**
	 * Original signature : <code>int zmq_msg_recv(zmq_msg_t*, void*, int)</code><br>
	 * <i>native declaration : zmq.h:55</i>
	 */
	int zmq_msg_recv(zmq_msg_t msg_, Pointer s_, int flags_);
	/**
	 * Original signature : <code>int zmq_msg_close(zmq_msg_t*)</code><br>
	 * <i>native declaration : zmq.h:57</i>
	 */
	int zmq_msg_close(zmq_msg_t msg_);
	/**
	 * Original signature : <code>int zmq_msg_move(zmq_msg_t*, zmq_msg_t*)</code><br>
	 * <i>native declaration : zmq.h:59</i>
	 */
	int zmq_msg_move(zmq_msg_t dest_, zmq_msg_t src_);
	/**
	 * Original signature : <code>int zmq_msg_copy(zmq_msg_t*, zmq_msg_t*)</code><br>
	 * <i>native declaration : zmq.h:61</i>
	 */
	int zmq_msg_copy(zmq_msg_t dest_, zmq_msg_t src_);
	/**
	 * Original signature : <code>void* zmq_msg_data(zmq_msg_t*)</code><br>
	 * <i>native declaration : zmq.h:63</i>
	 */
	Pointer zmq_msg_data(zmq_msg_t msg_);
	/**
	 * Original signature : <code>size_t zmq_msg_size(const zmq_msg_t*)</code><br>
	 * <i>native declaration : zmq.h:65</i>
	 */
	NativeSize zmq_msg_size(zmq_msg_t msg_);
	/**
	 * Original signature : <code>int zmq_msg_more(const zmq_msg_t*)</code><br>
	 * <i>native declaration : zmq.h:67</i>
	 */
	int zmq_msg_more(zmq_msg_t msg_);
	/**
	 * Original signature : <code>int zmq_msg_get(const zmq_msg_t*, int)</code><br>
	 * <i>native declaration : zmq.h:69</i>
	 */
	int zmq_msg_get(zmq_msg_t msg_, int property_);
	/**
	 * Original signature : <code>int zmq_msg_set(zmq_msg_t*, int, int)</code><br>
	 * <i>native declaration : zmq.h:71</i>
	 */
	int zmq_msg_set(zmq_msg_t msg_, int property_, int optval_);
	/**
	 * Original signature : <code>char* zmq_msg_gets(const zmq_msg_t*, const char*)</code><br>
	 * <i>native declaration : zmq.h:73</i><br>
	 * @deprecated use the safer methods zmq_msg_gets(libzmq.zmq_msg_t, String) and #zmq_msg_gets(libzmq.zmq_msg_t, Pointer) instead
	 */
	@Deprecated
	Pointer zmq_msg_gets(zmq_msg_t msg_, Pointer property_);
	/**
	 * Original signature : <code>char* zmq_msg_gets(const zmq_msg_t*, const char*)</code><br>
	 * <i>native declaration : zmq.h:73</i>
	 */
	Pointer zmq_msg_gets(zmq_msg_t msg_, String property_);
	/**
	 * the following two may be due to erroneous configuration of a peer<br>
	 * Original signature : <code>void* zmq_socket(void*, int)</code><br>
	 * <i>native declaration : zmq.h:78</i>
	 */
	Pointer zmq_socket(Pointer voidPtr1, int type_);
	/**
	 * Original signature : <code>int zmq_close(void*)</code><br>
	 * <i>native declaration : zmq.h:80</i>
	 */
	int zmq_close(Pointer s_);
	/**
	 * Original signature : <code>int zmq_setsockopt(void*, int, const void*, size_t)</code><br>
	 * <i>native declaration : zmq.h:82</i>
	 */
	int zmq_setsockopt(Pointer s_, int option_, Pointer optval_, NativeSize optvallen_);
	/**
	 * Original signature : <code>int zmq_getsockopt(void*, int, void*, size_t*)</code><br>
	 * <i>native declaration : zmq.h:84</i>
	 */
	int zmq_getsockopt(Pointer s_, int option_, Pointer optval_, NativeSizeByReference optvallen_);
	/**
	 * Original signature : <code>int zmq_bind(void*, const char*)</code><br>
	 * <i>native declaration : zmq.h:86</i><br>
	 * @deprecated use the safer methods {@link #zmq_bind(Pointer, String)} and {@link #zmq_bind(Pointer, Pointer)} instead
	 */
	@Deprecated
	int zmq_bind(Pointer s_, Pointer addr_);
	/**
	 * Original signature : <code>int zmq_bind(void*, const char*)</code><br>
	 * <i>native declaration : zmq.h:86</i>
	 */
	int zmq_bind(Pointer s_, String addr_);
	/**
	 * Original signature : <code>int zmq_connect(void*, const char*)</code><br>
	 * <i>native declaration : zmq.h:88</i><br>
	 * @deprecated use the safer methods {@link #zmq_connect(Pointer, String)} and {@link #zmq_connect(Pointer, Pointer)} instead
	 */
	@Deprecated
	int zmq_connect(Pointer s_, Pointer addr_);
	/**
	 * Original signature : <code>int zmq_connect(void*, const char*)</code><br>
	 * <i>native declaration : zmq.h:88</i>
	 */
	int zmq_connect(Pointer s_, String addr_);
	/**
	 * Original signature : <code>int zmq_unbind(void*, const char*)</code><br>
	 * <i>native declaration : zmq.h:90</i><br>
	 * @deprecated use the safer methods {@link #zmq_unbind(Pointer, String)} and {@link #zmq_unbind(Pointer, Pointer)} instead
	 */
	@Deprecated
	int zmq_unbind(Pointer s_, Pointer addr_);
	/**
	 * Original signature : <code>int zmq_unbind(void*, const char*)</code><br>
	 * <i>native declaration : zmq.h:90</i>
	 */
	int zmq_unbind(Pointer s_, String addr_);
	/**
	 * Original signature : <code>int zmq_disconnect(void*, const char*)</code><br>
	 * <i>native declaration : zmq.h:92</i><br>
	 * @deprecated use the safer methods {@link #zmq_disconnect(Pointer, String)} and {@link #zmq_disconnect(Pointer, Pointer)} instead
	 */
	@Deprecated
	int zmq_disconnect(Pointer s_, Pointer addr_);
	/**
	 * Original signature : <code>int zmq_disconnect(void*, const char*)</code><br>
	 * <i>native declaration : zmq.h:92</i>
	 */
	int zmq_disconnect(Pointer s_, String addr_);
	/**
	 * Original signature : <code>int zmq_send(void*, const void*, size_t, int)</code><br>
	 * <i>native declaration : zmq.h:94</i>
	 */
	int zmq_send(Pointer s_, Pointer buf_, NativeSize len_, int flags_);
	/**
	 * Original signature : <code>int zmq_send_const(void*, const void*, size_t, int)</code><br>
	 * <i>native declaration : zmq.h:96</i>
	 */
	int zmq_send_const(Pointer s_, Pointer buf_, NativeSize len_, int flags_);
	/**
	 * Original signature : <code>int zmq_recv(void*, void*, size_t, int)</code><br>
	 * <i>native declaration : zmq.h:98</i>
	 */
	int zmq_recv(Pointer s_, Pointer buf_, NativeSize len_, int flags_);
	/**
	 * Original signature : <code>int zmq_socket_monitor(void*, const char*, int)</code><br>
	 * <i>native declaration : zmq.h:100</i><br>
	 * @deprecated use the safer methods {@link #zmq_socket_monitor(Pointer, String, int)} and {@link #zmq_socket_monitor(Pointer, Pointer, int)} instead
	 */
	@Deprecated
	int zmq_socket_monitor(Pointer s_, Pointer addr_, int events_);
	/**
	 * Original signature : <code>int zmq_socket_monitor(void*, const char*, int)</code><br>
	 * <i>native declaration : zmq.h:100</i>
	 */
	int zmq_socket_monitor(Pointer s_, String addr_, int events_);
	/**
	 * Original signature : <code>int zmq_poll(zmq_pollitem_t*, int, long)</code><br>
	 * <i>native declaration : zmq.h:109</i>
	 */
	int zmq_poll(zmq_pollitem_t items_, int nitems_, NativeLong timeout_);
	/**
	 * /<br>
	 * Original signature : <code>int zmq_proxy(void*, void*, void*)</code><br>
	 * <i>native declaration : zmq.h:114</i>
	 */
	int zmq_proxy(Pointer frontend_, Pointer backend_, Pointer capture_);
	/**
	 * Original signature : <code>int zmq_proxy_steerable(void*, void*, void*, void*)</code><br>
	 * <i>native declaration : zmq.h:116</i>
	 */
	int zmq_proxy_steerable(Pointer frontend_, Pointer backend_, Pointer capture_, Pointer control_);
	/**
	 * /<br>
	 * Original signature : <code>int zmq_has(const char*)</code><br>
	 * <i>native declaration : zmq.h:121</i><br>
	 * @deprecated use the safer methods {@link #zmq_has(String)} and {@link #zmq_has(Pointer)} instead
	 */
	@Deprecated
	int zmq_has(Pointer capability_);
	/**
	 * /<br>
	 * Original signature : <code>int zmq_has(const char*)</code><br>
	 * <i>native declaration : zmq.h:121</i>
	 */
	int zmq_has(String capability_);
	/**
	 * Deprecated methods<br>
	 * Original signature : <code>int zmq_device(int, void*, void*)</code><br>
	 * <i>native declaration : zmq.h:126</i>
	 */
	int zmq_device(int type_, Pointer frontend_, Pointer backend_);
	/**
	 * Original signature : <code>int zmq_sendmsg(void*, zmq_msg_t*, int)</code><br>
	 * <i>native declaration : zmq.h:128</i>
	 */
	int zmq_sendmsg(Pointer s_, zmq_msg_t msg_, int flags_);
	/**
	 * Original signature : <code>int zmq_recvmsg(void*, zmq_msg_t*, int)</code><br>
	 * <i>native declaration : zmq.h:130</i>
	 */
	int zmq_recvmsg(Pointer s_, zmq_msg_t msg_, int flags_);
	/**
	 * Original signature : <code>int zmq_sendiov(void*, iovec*, size_t, int)</code><br>
	 * <i>native declaration : zmq.h:133</i>
	 */
	int zmq_sendiov(Pointer s_, iovec iov_, NativeSize count_, int flags_);
	/**
	 * Original signature : <code>int zmq_recviov(void*, iovec*, size_t*, int)</code><br>
	 * <i>native declaration : zmq.h:135</i>
	 */
	int zmq_recviov(Pointer s_, iovec iov_, NativeSizeByReference count_, int flags_);
	/**
	 * Encode data with Z85 encoding. Returns encoded data<br>
	 * Original signature : <code>char* zmq_z85_encode(char*, const uint8_t*, size_t)</code><br>
	 * <i>native declaration : zmq.h:140</i><br>
	 * @deprecated use the safer methods {@link #zmq_z85_encode(ByteBuffer, byte[], com.ochafik.lang.jnaerator.runtime.NativeSize)} and {@link #zmq_z85_encode(Pointer, Pointer, com.ochafik.lang.jnaerator.runtime.NativeSize)} instead
	 */
	@Deprecated
	Pointer zmq_z85_encode(Pointer dest_, Pointer data_, NativeSize size_);
	/**
	 * Encode data with Z85 encoding. Returns encoded data<br>
	 * Original signature : <code>char* zmq_z85_encode(char*, const uint8_t*, size_t)</code><br>
	 * <i>native declaration : zmq.h:140</i>
	 */
	Pointer zmq_z85_encode(ByteBuffer dest_, byte[] data_, NativeSize size_);
	/**
	 * Decode data with Z85 encoding. Returns decoded data<br>
	 * Original signature : <code>uint8_t* zmq_z85_decode(uint8_t*, const char*)</code><br>
	 * <i>native declaration : zmq.h:145</i><br>
	 * @deprecated use the safer methods {@link #zmq_z85_decode(ByteBuffer, String)} and {@link #zmq_z85_decode(Pointer, Pointer)} instead
	 */
	@Deprecated
	Pointer zmq_z85_decode(Pointer dest_, Pointer string_);
	/**
	 * Decode data with Z85 encoding. Returns decoded data<br>
	 * Original signature : <code>uint8_t* zmq_z85_decode(uint8_t*, const char*)</code><br>
	 * <i>native declaration : zmq.h:145</i>
	 */
	Pointer zmq_z85_decode(ByteBuffer dest_, String string_);
	/**
	 * Returns 0 on success.<br>
	 * Original signature : <code>int zmq_curve_keypair(char*, char*)</code><br>
	 * <i>native declaration : zmq.h:150</i><br>
	 * @deprecated use the safer methods {@link #zmq_curve_keypair(ByteBuffer, ByteBuffer)} and {@link #zmq_curve_keypair(Pointer, Pointer)} instead
	 */
	@Deprecated
	int zmq_curve_keypair(Pointer z85_public_key_, Pointer z85_secret_key_);
	/**
	 * Returns 0 on success.<br>
	 * Original signature : <code>int zmq_curve_keypair(char*, char*)</code><br>
	 * <i>native declaration : zmq.h:150</i>
	 */
	int zmq_curve_keypair(ByteBuffer z85_public_key_, ByteBuffer z85_secret_key_);
	/**
	 * Returns 0 on success.<br>
	 * Original signature : <code>int zmq_curve_public(char*, const char*)</code><br>
	 * <i>native declaration : zmq.h:155</i><br>
	 * @deprecated use the safer methods {@link #zmq_curve_public(ByteBuffer, String)} and {@link #zmq_curve_public(Pointer, Pointer)} instead
	 */
	@Deprecated
	int zmq_curve_public(Pointer z85_public_key_, Pointer z85_secret_key_);
	/**
	 * Returns 0 on success.<br>
	 * Original signature : <code>int zmq_curve_public(char*, const char*)</code><br>
	 * <i>native declaration : zmq.h:155</i>
	 */
	int zmq_curve_public(ByteBuffer z85_public_key_, String z85_secret_key_);
	/**
	 * /<br>
	 * Original signature : <code>void* zmq_atomic_counter_new()</code><br>
	 * <i>native declaration : zmq.h:160</i>
	 */
	Pointer zmq_atomic_counter_new();
	/**
	 * Original signature : <code>void zmq_atomic_counter_set(void*, int)</code><br>
	 * <i>native declaration : zmq.h:162</i>
	 */
	void zmq_atomic_counter_set(Pointer counter_, int value_);
	/**
	 * Original signature : <code>int zmq_atomic_counter_inc(void*)</code><br>
	 * <i>native declaration : zmq.h:164</i>
	 */
	int zmq_atomic_counter_inc(Pointer counter_);
	/**
	 * Original signature : <code>int zmq_atomic_counter_dec(void*)</code><br>
	 * <i>native declaration : zmq.h:166</i>
	 */
	int zmq_atomic_counter_dec(Pointer counter_);
	/**
	 * Original signature : <code>int zmq_atomic_counter_value(void*)</code><br>
	 * <i>native declaration : zmq.h:168</i>
	 */
	int zmq_atomic_counter_value(Pointer counter_);
	/**
	 * Original signature : <code>void zmq_atomic_counter_destroy(void**)</code><br>
	 * <i>native declaration : zmq.h:170</i>
	 */
	void zmq_atomic_counter_destroy(PointerByReference counter_p_);
	/**
	 * Original signature : <code>void* zmq_timers_new()</code><br>
	 * <i>native declaration : zmq.h:174</i>
	 */
	Pointer zmq_timers_new();
	/**
	 * Original signature : <code>int zmq_timers_destroy(void**)</code><br>
	 * <i>native declaration : zmq.h:176</i>
	 */
	int zmq_timers_destroy(PointerByReference timers_p);
	/**
	 * Original signature : <code>int zmq_timers_add(void*, size_t, zmq_timer_fn, void*)</code><br>
	 * <i>native declaration : zmq.h:178</i>
	 */
	int zmq_timers_add(Pointer timers, NativeSize interval, zmq_timer_fn handler, Pointer arg);
	/**
	 * Original signature : <code>int zmq_timers_cancel(void*, int)</code><br>
	 * <i>native declaration : zmq.h:180</i>
	 */
	int zmq_timers_cancel(Pointer timers, int timer_id);
	/**
	 * Original signature : <code>int zmq_timers_set_interval(void*, int, size_t)</code><br>
	 * <i>native declaration : zmq.h:182</i>
	 */
	int zmq_timers_set_interval(Pointer timers, int timer_id, NativeSize interval);
	/**
	 * Original signature : <code>int zmq_timers_reset(void*, int)</code><br>
	 * <i>native declaration : zmq.h:184</i>
	 */
	int zmq_timers_reset(Pointer timers, int timer_id);
	/**
	 * Original signature : <code>long zmq_timers_timeout(void*)</code><br>
	 * <i>native declaration : zmq.h:186</i>
	 */
	NativeLong zmq_timers_timeout(Pointer timers);
	/**
	 * Original signature : <code>int zmq_timers_execute(void*)</code><br>
	 * <i>native declaration : zmq.h:188</i>
	 */
	int zmq_timers_execute(Pointer timers);
	/**
	 * Starts the stopwatch. Returns the handle to the watch.<br>
	 * Original signature : <code>void* zmq_stopwatch_start()</code><br>
	 * <i>native declaration : zmq.h:193</i>
	 */
	Pointer zmq_stopwatch_start();
	/**
	 * started, but does not stop or deallocate the stopwatch.<br>
	 * Original signature : <code>long zmq_stopwatch_intermediate(void*)</code><br>
	 * <i>native declaration : zmq.h:198</i>
	 */
	NativeLong zmq_stopwatch_intermediate(Pointer watch_);
	/**
	 * the stopwatch was started, and deallocates that watch.<br>
	 * Original signature : <code>long zmq_stopwatch_stop(void*)</code><br>
	 * <i>native declaration : zmq.h:203</i>
	 */
	NativeLong zmq_stopwatch_stop(Pointer watch_);
	/**
	 * Sleeps for specified number of seconds.<br>
	 * Original signature : <code>void zmq_sleep(int)</code><br>
	 * <i>native declaration : zmq.h:208</i>
	 */
	void zmq_sleep(int seconds_);
	/**
	 * Start a thread. Returns a handle to the thread.<br>
	 * Original signature : <code>void* zmq_threadstart(zmq_thread_fn*, void*)</code><br>
	 * <i>native declaration : zmq.h:214</i>
	 */
	Pointer zmq_threadstart(zmq_thread_fn func_, Pointer arg_);
	/**
	 * Wait for thread to complete then free up resources.<br>
	 * Original signature : <code>void zmq_threadclose(void*)</code><br>
	 * <i>native declaration : zmq.h:219</i>
	 */
	void zmq_threadclose(Pointer thread_);
	class iovec extends PointerType {
		public iovec(Pointer address) {
			super(address);
		}
		public iovec() {
			super();
		}
	}

	class SOCKET extends PointerType {
		public SOCKET(Pointer address) {
			super(address);
		}
		public SOCKET() {
			super();
		}
	}

	/*
	 added stuff
	 */
	int ZMQ_RADIO = 14;
	int ZMQ_DISH = 15;
	int zmq_join(Pointer socket, String groupName);
	int zmq_msg_set_group(zmq_msg_t msg, String groupName);

}
