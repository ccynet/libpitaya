// Targeted by JavaCPP version 1.4.4: DO NOT EDIT THIS FILE

package dog.tale.pitaya;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

public class Pitaya extends dog.tale.pitaya.PitayaConfig {
    static { Loader.load(); }

// Parsed from pitaya_version.h

public static final int PC_VERSION_MAJOR = 1;
public static final int PC_VERSION_MINOR = 9;
public static final int PC_VERSION_REVISION = 5;
public static final String PC_VERSION_SUFFIX = "";

// Parsed from pitaya.h

/**
 * Copyright (c) 2014 NetEase, Inc. and other Pomelo contributors
 * MIT Licensed.
 */

// #ifndef PC_PITAYA_H
// #define PC_PITAYA_H

// #include <stddef.h>
// #include <stdbool.h>
// #include <stdint.h>

// #ifdef __cplusplus
// #endif

// #ifdef _WIN32
// #define PC_EXPORT __declspec(dllexport)
// #else
// #define PC_EXPORT
// #endif

// #include "pitaya_version.h"

// #define PC_T(x) PC_T2(x)
// #define PC_T2(x) #x

public static final int PC_VERSION_NUM = (PC_VERSION_MAJOR * 10000 + PC_VERSION_MINOR * 100 + PC_VERSION_REVISION);
// #define PC_VERSION_STR ( PC_T(PC_VERSION_MAJOR) "." PC_T(PC_VERSION_MINOR)
//         "." PC_T(PC_VERSION_REVISION) "-" PC_VERSION_SUFFIX )

/**
 * error code
 */
public static final int PC_RC_OK = 0;
public static final int PC_RC_ERROR = -1;
public static final int PC_RC_TIMEOUT = -2;
public static final int PC_RC_INVALID_JSON = -3;
public static final int PC_RC_INVALID_ARG = -4;
public static final int PC_RC_NO_TRANS = -5;
public static final int PC_RC_INVALID_THREAD = -6;
public static final int PC_RC_TRANS_ERROR = -7;
public static final int PC_RC_INVALID_ROUTE = -8;
public static final int PC_RC_INVALID_STATE = -9;
public static final int PC_RC_NOT_FOUND = -10;
public static final int PC_RC_RESET = -11;
public static final int PC_RC_SERVER_ERROR = -12;
public static final int PC_RC_UV_ERROR = -13;
public static final int PC_RC_NO_SUCH_FILE = -14;
public static final int PC_RC_MIN = -15;

@Opaque public static class pc_client_t extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public pc_client_t() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pc_client_t(Pointer p) { super(p); }
}
@Opaque public static class pc_request_t extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public pc_request_t() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pc_request_t(Pointer p) { super(p); }
}
@Opaque public static class pc_notify_t extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public pc_notify_t() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pc_notify_t(Pointer p) { super(p); }
}

/**
 * client state
 */
public static final int PC_ST_INITED = 0;
public static final int PC_ST_CONNECTING = 1;
public static final int PC_ST_CONNECTED = 2;
public static final int PC_ST_DISCONNECTING = 3;
public static final int PC_ST_UNKNOWN = 4;
public static final int PC_ST_COUNT = 5;


/**
 * log level
 */
public static final int PC_LOG_DEBUG = 0;
public static final int PC_LOG_INFO = 1;
public static final int PC_LOG_WARN = 2;
public static final int PC_LOG_ERROR = 3;
public static final int PC_LOG_DISABLE = 4;

/**
 * some tunable arguments
 */
public static final int PC_TRANSPORT_PLUGIN_SLOT_COUNT = 8;
public static final int PC_PRE_ALLOC_REQUEST_SLOT_COUNT = 4;
public static final int PC_PRE_ALLOC_NOTIFY_SLOT_COUNT = 4;
public static final int PC_TIMEOUT_CHECK_INTERVAL = 2;
public static final int PC_HEARTBEAT_TIMEOUT_FACTOR = 2;
public static final int PC_TCP_READ_BUFFER_SIZE = (1 << 16);

/**
 * builtin transport name
 */
public static final int PC_TR_NAME_UV_TCP = 0;
public static final int PC_TR_NAME_UV_TLS = 1;
public static final int PC_TR_NAME_DUMMY = 7;

/**
 * reconnect max retry
 */
public static final int PC_ALWAYS_RETRY = -1;

/**
 * disable timeout
 */
public static final int PC_WITHOUT_TIMEOUT = -1;

/** enum pc_local_storage_op_t */
public static final int
    PC_LOCAL_STORAGE_OP_READ = 0,
    PC_LOCAL_STORAGE_OP_WRITE = 1;
public static class pc_local_storage_cb_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    pc_local_storage_cb_t(Pointer p) { super(p); }
    protected pc_local_storage_cb_t() { allocate(); }
    private native void allocate();
    public native int call(@Cast("pc_local_storage_op_t") int op,
        @Cast("char*") BytePointer data, @Cast("size_t*") SizeTPointer len, Pointer ex_data);
}

/**
 * Binary buffer
 */
public static class pc_buf_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public pc_buf_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public pc_buf_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pc_buf_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public pc_buf_t position(long position) {
        return (pc_buf_t)super.position(position);
    }

    public native @Cast("uint8_t*") BytePointer base(); public native pc_buf_t base(BytePointer base);
    public native @Cast("int64_t") long len(); public native pc_buf_t len(long len);
}

@NoException public static native @ByVal pc_buf_t pc_buf_empty();
@NoException public static native @ByVal pc_buf_t pc_buf_copy(@Const pc_buf_t buf);
@NoException public static native void pc_buf_free(pc_buf_t buf);
@NoException public static native @ByVal pc_buf_t pc_buf_from_string(@Cast("const char*") BytePointer str);
@NoException public static native @ByVal pc_buf_t pc_buf_from_string(String str);
@NoException public static native void pc_buf_debug_print(@Const pc_buf_t buf);

/**
 * Push
 */
public static class pc_push_handler_cb_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    pc_push_handler_cb_t(Pointer p) { super(p); }
    protected pc_push_handler_cb_t() { allocate(); }
    private native void allocate();
    public native void call(pc_client_t client, @Cast("const char*") BytePointer route, @Const pc_buf_t payload);
}

@NoException public static native void pc_client_set_push_handler(pc_client_t client, pc_push_handler_cb_t cb);

public static class pc_client_config_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public pc_client_config_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public pc_client_config_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pc_client_config_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public pc_client_config_t position(long position) {
        return (pc_client_config_t)super.position(position);
    }

    public native int conn_timeout(); public native pc_client_config_t conn_timeout(int conn_timeout);

    public native int enable_reconn(); public native pc_client_config_t enable_reconn(int enable_reconn);
    public native int reconn_max_retry(); public native pc_client_config_t reconn_max_retry(int reconn_max_retry);
    public native int reconn_delay(); public native pc_client_config_t reconn_delay(int reconn_delay);
    public native int reconn_delay_max(); public native pc_client_config_t reconn_delay_max(int reconn_delay_max);
    public native int reconn_exp_backoff(); public native pc_client_config_t reconn_exp_backoff(int reconn_exp_backoff);

    public native int enable_polling(); public native pc_client_config_t enable_polling(int enable_polling);

    public native pc_local_storage_cb_t local_storage_cb(); public native pc_client_config_t local_storage_cb(pc_local_storage_cb_t local_storage_cb);
    public native Pointer ls_ex_data(); public native pc_client_config_t ls_ex_data(Pointer ls_ex_data);

    public native int transport_name(); public native pc_client_config_t transport_name(int transport_name);

    public native int disable_compression(); public native pc_client_config_t disable_compression(int disable_compression);
}

public static final int PC_CLIENT_CONFIG_DEFAULT_CONN_TIMEOUT = 30;
public static final int PC_CLIENT_CONFIG_DEFAULT_ENABLE_RECONN = 1;
public static final int PC_CLIENT_CONFIG_DEFAULT_RECONN_MAX_RETRY = PC_ALWAYS_RETRY;
public static final int PC_CLIENT_CONFIG_DEFAULT_RECONN_DELAY = 2;
public static final int PC_CLIENT_CONFIG_DEFAULT_RECONN_DELAY_MAX = 30;
public static final int PC_CLIENT_CONFIG_DEFAULT_RECONN_EXP_BACKOFF = 1;
public static final int PC_CLIENT_CONFIG_DEFAULT_ENABLE_POLLING = 0;
public static final int PC_CLIENT_CONFIG_DEFAULT_TRANSPORT_NAME = PC_TR_NAME_UV_TCP;
public static final int PC_CLIENT_CONFIG_DEFAULT_DISABLE_COMPRESSION = 0;

// #define PC_CLIENT_CONFIG_DEFAULT
// {
//     30, /* conn_timeout */
//     1, /* enable_reconn */
//     PC_ALWAYS_RETRY, /* reconn_max_retry */
//     2, /* reconn_delay */
//     30, /* reconn_delay_max */
//     1, /* reconn_exp_backoff */
//     0, /* enable_polling */
//     NULL, /* local_storage_cb */
//     NULL, /* ls_ex_data */
//     PC_TR_NAME_UV_TCP, /* transport_name */
//     0 /* disable_compression */
// }

@NoException public static native int pc_lib_version();
@NoException public static native @Cast("const char*") BytePointer pc_lib_version_str();

/**
 * If you do use default log callback,
 * this function will change the level of log out.
 *
 * Otherwise, this function does nothing.
 */
@NoException public static native void pc_lib_set_default_log_level(int level);
@NoException public static native int pc_lib_get_default_log_level();

/**
 * pc_lib_init and pc_lib_cleanup both should be invoked only once.
 */
public static class pc_lib_client_info_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public pc_lib_client_info_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public pc_lib_client_info_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pc_lib_client_info_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public pc_lib_client_info_t position(long position) {
        return (pc_lib_client_info_t)super.position(position);
    }

    @MemberGetter public native @Cast("const char*") BytePointer platform();
    @MemberGetter public native @Cast("const char*") BytePointer build_number();
    @MemberGetter public native @Cast("const char*") BytePointer version();
}

public static class Pc_log_int_BytePointer extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Pc_log_int_BytePointer(Pointer p) { super(p); }
    protected Pc_log_int_BytePointer() { allocate(); }
    private native void allocate();
    public native void call(int level, @Cast("const char*") BytePointer msg);
}
public static class Pc_alloc_long extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Pc_alloc_long(Pointer p) { super(p); }
    protected Pc_alloc_long() { allocate(); }
    private native void allocate();
    public native Pointer call(@Cast("size_t") long arg0);
}
public static class Pc_free_Pointer extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Pc_free_Pointer(Pointer p) { super(p); }
    protected Pc_free_Pointer() { allocate(); }
    private native void allocate();
    public native void call(Pointer arg0 );
}
public static class Pc_realloc_Pointer_long extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Pc_realloc_Pointer_long(Pointer p) { super(p); }
    protected Pc_realloc_Pointer_long() { allocate(); }
    private native void allocate();
    public native Pointer call(Pointer arg0, @Cast("size_t") long arg1);
}
@NoException public static native void pc_lib_init(Pc_log_int_BytePointer pc_log,
                           Pc_alloc_long pc_alloc,
                           Pc_free_Pointer pc_free,
                           Pc_realloc_Pointer_long pc_realloc,
                           @ByVal pc_lib_client_info_t client_info);
public static class Pc_log_int_String extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Pc_log_int_String(Pointer p) { super(p); }
    protected Pc_log_int_String() { allocate(); }
    private native void allocate();
    public native void call(int level, String msg);
}
@NoException public static native void pc_lib_init(Pc_log_int_String pc_log,
                           Pc_alloc_long pc_alloc,
                           Pc_free_Pointer pc_free,
                           Pc_realloc_Pointer_long pc_realloc,
                           @ByVal pc_lib_client_info_t client_info);

@NoException public static native void pc_update_client_info(@ByVal pc_lib_client_info_t client_info);

/**
 * Pins a public key globally for all clients.
 */
@NoException public static native int pc_lib_add_pinned_public_key_from_certificate_string(@Cast("const char*") BytePointer ca_string);
@NoException public static native int pc_lib_add_pinned_public_key_from_certificate_string(String ca_string);
@NoException public static native int pc_lib_add_pinned_public_key_from_certificate_file(@Cast("const char*") BytePointer ca_path);
@NoException public static native int pc_lib_add_pinned_public_key_from_certificate_file(String ca_path);
@NoException public static native void pc_lib_skip_key_pin_check(@Cast("bool") boolean should_skip);

/**
 * Remote all pinned public keys.
 */
@NoException public static native void pc_lib_clear_pinned_public_keys();

@NoException public static native void pc_lib_cleanup();

public static class pc_client_init_result_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public pc_client_init_result_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public pc_client_init_result_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pc_client_init_result_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public pc_client_init_result_t position(long position) {
        return (pc_client_init_result_t)super.position(position);
    }

    public native pc_client_t client(); public native pc_client_init_result_t client(pc_client_t client);
    public native int rc(); public native pc_client_init_result_t rc(int rc);
}

@NoException public static native @Cast("size_t") long pc_client_size();
@NoException public static native @ByVal pc_client_init_result_t pc_client_init(Pointer ex_data, @Const pc_client_config_t config);
@NoException public static native int pc_client_connect(pc_client_t client, @Cast("const char*") BytePointer host, int port, @Cast("const char*") BytePointer handshake_opts);
@NoException public static native int pc_client_connect(pc_client_t client, String host, int port, String handshake_opts);
@NoException public static native int pc_client_disconnect(pc_client_t client);
@NoException public static native int pc_client_cleanup(pc_client_t client);
@NoException public static native int pc_client_poll(pc_client_t client);

/**
 * pc_client_t getters
 */
@NoException public static native Pointer pc_client_ex_data(@Const pc_client_t client);
@NoException public static native @Const pc_client_config_t pc_client_config(@Const pc_client_t client);
@NoException public static native int pc_client_state(pc_client_t client);
@NoException public static native int pc_client_conn_quality(pc_client_t client);
@NoException public static native Pointer pc_client_trans_data(pc_client_t client);
@NoException public static native @Cast("const char*") BytePointer pc_client_serializer(pc_client_t client);

// Free serializer
@NoException public static native void pc_client_free_serializer(@Cast("const char*") BytePointer serializer);
@NoException public static native void pc_client_free_serializer(String serializer);

/**
 * Event
 */

/**
 * event handler callback and event types
 *
 * arg1 and arg2 are significant for the following events:
 *   PC_EV_USER_DEFINED_PUSH - arg1 as push route, arg2 as push msg
 *   PC_EV_CONNECT_ERROR - arg1 as short error description
 *   PC_EV_CONNECT_FAILED - arg1 as short reason description
 *   PC_EV_UNEXPECTED_DISCONNECT - arg1 as short reason description
 *   PC_EV_PROTO_ERROR - arg1 as short reason description
 *   PC_EV_RECONNECT_FAILED - arg1 as short reason description
 *
 * For other events, arg1 and arg2 will be set to NULL.
 */
public static class pc_event_cb_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    pc_event_cb_t(Pointer p) { super(p); }
    protected pc_event_cb_t() { allocate(); }
    private native void allocate();
    public native void call(pc_client_t client, int ev_type, Pointer ex_data,
                              @Cast("const char*") BytePointer arg1, @Cast("const char*") BytePointer arg2);
}

public static final int PC_EV_USER_DEFINED_PUSH = 0;
public static final int PC_EV_CONNECTED = 1;
public static final int PC_EV_CONNECT_ERROR = 2;
public static final int PC_EV_CONNECT_FAILED = 3;
public static final int PC_EV_DISCONNECT = 4;
public static final int PC_EV_KICKED_BY_SERVER = 5;
public static final int PC_EV_UNEXPECTED_DISCONNECT = 6;
public static final int PC_EV_PROTO_ERROR = 7;
public static final int PC_EV_RECONNECT_FAILED = 8;
public static final int PC_EV_RECONNECT_STARTED = 9;
public static final int PC_EV_COUNT = 10;

public static final int PC_EV_INVALID_HANDLER_ID = -1;

public static class Destructor_Pointer extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Destructor_Pointer(Pointer p) { super(p); }
    protected Destructor_Pointer() { allocate(); }
    private native void allocate();
    public native void call(Pointer ex_data);
}
@NoException public static native int pc_client_add_ev_handler(pc_client_t client, pc_event_cb_t cb,
        Pointer ex_data, Destructor_Pointer destructor);
@NoException public static native int pc_client_rm_ev_handler(pc_client_t client, int id);

/**
 * Error
 */
public static class pc_error_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public pc_error_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public pc_error_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public pc_error_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public pc_error_t position(long position) {
        return (pc_error_t)super.position(position);
    }

    public native int code(); public native pc_error_t code(int code);
    public native @ByRef pc_buf_t payload(); public native pc_error_t payload(pc_buf_t payload);
    public native int uv_code(); public native pc_error_t uv_code(int uv_code);
}

/**
 * Request
 */

public static class pc_request_success_cb_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    pc_request_success_cb_t(Pointer p) { super(p); }
    protected pc_request_success_cb_t() { allocate(); }
    private native void allocate();
    public native void call(@Const pc_request_t req, @Const pc_buf_t resp);
}
public static class pc_request_error_cb_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    pc_request_error_cb_t(Pointer p) { super(p); }
    protected pc_request_error_cb_t() { allocate(); }
    private native void allocate();
    public native void call(@Const pc_request_t req, @Const pc_error_t error);
}

/**
 * pc_request_t getters.
 *
 * All the getters should be called in pc_request_cb_t to access read-only
 * properties of the current pc_request_t.
 *
 * User should not hold any references to pc_request_t.
 */
@NoException public static native pc_client_t pc_request_client(@Const pc_request_t req);
@NoException public static native @Cast("const char*") BytePointer pc_request_route(@Const pc_request_t req);
@NoException public static native @Cast("const char*") BytePointer pc_request_msg(@Const pc_request_t req);
@NoException public static native int pc_request_timeout(@Const pc_request_t req);
@NoException public static native Pointer pc_request_ex_data(@Const pc_request_t req);

/**
 * Initiate a request.
 */
@NoException public static native int pc_string_request_with_timeout(pc_client_t client, @Cast("const char*") BytePointer route,
                                             @Cast("const char*") BytePointer str, Pointer ex_data, int timeout,
                                             pc_request_success_cb_t success_cb, pc_request_error_cb_t error_cb);
@NoException public static native int pc_string_request_with_timeout(pc_client_t client, String route,
                                             String str, Pointer ex_data, int timeout,
                                             pc_request_success_cb_t success_cb, pc_request_error_cb_t error_cb);

@NoException public static native int pc_binary_request_with_timeout(pc_client_t client, @Cast("const char*") BytePointer route,
                                             @Cast("uint8_t*") BytePointer data, @Cast("int64_t") long len, Pointer ex_data, int timeout,
                                             pc_request_success_cb_t success_cb, pc_request_error_cb_t error_cb);
@NoException public static native int pc_binary_request_with_timeout(pc_client_t client, String route,
                                             @Cast("uint8_t*") ByteBuffer data, @Cast("int64_t") long len, Pointer ex_data, int timeout,
                                             pc_request_success_cb_t success_cb, pc_request_error_cb_t error_cb);
@NoException public static native int pc_binary_request_with_timeout(pc_client_t client, @Cast("const char*") BytePointer route,
                                             @Cast("uint8_t*") byte[] data, @Cast("int64_t") long len, Pointer ex_data, int timeout,
                                             pc_request_success_cb_t success_cb, pc_request_error_cb_t error_cb);
@NoException public static native int pc_binary_request_with_timeout(pc_client_t client, String route,
                                             @Cast("uint8_t*") BytePointer data, @Cast("int64_t") long len, Pointer ex_data, int timeout,
                                             pc_request_success_cb_t success_cb, pc_request_error_cb_t error_cb);
@NoException public static native int pc_binary_request_with_timeout(pc_client_t client, @Cast("const char*") BytePointer route,
                                             @Cast("uint8_t*") ByteBuffer data, @Cast("int64_t") long len, Pointer ex_data, int timeout,
                                             pc_request_success_cb_t success_cb, pc_request_error_cb_t error_cb);
@NoException public static native int pc_binary_request_with_timeout(pc_client_t client, String route,
                                             @Cast("uint8_t*") byte[] data, @Cast("int64_t") long len, Pointer ex_data, int timeout,
                                             pc_request_success_cb_t success_cb, pc_request_error_cb_t error_cb);

/**
 * Notify
 */

public static class pc_notify_error_cb_t extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    pc_notify_error_cb_t(Pointer p) { super(p); }
    protected pc_notify_error_cb_t() { allocate(); }
    private native void allocate();
    public native void call(@Const pc_notify_t req, @Const pc_error_t error);
}

/**
 * pc_notify_t getters.
 *
 * All the getters should be called in pc_notify_cb_t to access read-only
 * properties of the current pc_notify_t.
 *
 * User should not hold any references to pc_notify_t.
 */
@NoException public static native pc_client_t pc_notify_client(@Const pc_notify_t notify);
@NoException public static native @Cast("const char*") BytePointer pc_notify_route(@Const pc_notify_t notify);
@NoException public static native @Const pc_buf_t pc_notify_msg(@Const pc_notify_t notify);
@NoException public static native int pc_notify_timeout(@Const pc_notify_t notify);
@NoException public static native Pointer pc_notify_ex_data(@Const pc_notify_t notify);

/**
 * Initiate a notify.
 */
@NoException public static native int pc_binary_notify_with_timeout(pc_client_t client, @Cast("const char*") BytePointer route, @Cast("uint8_t*") BytePointer data, @Cast("int64_t") long len,
                                            Pointer ex_data, int timeout, pc_notify_error_cb_t cb);
@NoException public static native int pc_binary_notify_with_timeout(pc_client_t client, String route, @Cast("uint8_t*") ByteBuffer data, @Cast("int64_t") long len,
                                            Pointer ex_data, int timeout, pc_notify_error_cb_t cb);
@NoException public static native int pc_binary_notify_with_timeout(pc_client_t client, @Cast("const char*") BytePointer route, @Cast("uint8_t*") byte[] data, @Cast("int64_t") long len,
                                            Pointer ex_data, int timeout, pc_notify_error_cb_t cb);
@NoException public static native int pc_binary_notify_with_timeout(pc_client_t client, String route, @Cast("uint8_t*") BytePointer data, @Cast("int64_t") long len,
                                            Pointer ex_data, int timeout, pc_notify_error_cb_t cb);
@NoException public static native int pc_binary_notify_with_timeout(pc_client_t client, @Cast("const char*") BytePointer route, @Cast("uint8_t*") ByteBuffer data, @Cast("int64_t") long len,
                                            Pointer ex_data, int timeout, pc_notify_error_cb_t cb);
@NoException public static native int pc_binary_notify_with_timeout(pc_client_t client, String route, @Cast("uint8_t*") byte[] data, @Cast("int64_t") long len,
                                            Pointer ex_data, int timeout, pc_notify_error_cb_t cb);
@NoException public static native int pc_string_notify_with_timeout(pc_client_t client, @Cast("const char*") BytePointer route, @Cast("const char*") BytePointer str,
                                            Pointer ex_data, int timeout, pc_notify_error_cb_t cb);
@NoException public static native int pc_string_notify_with_timeout(pc_client_t client, String route, String str,
                                            Pointer ex_data, int timeout, pc_notify_error_cb_t cb);

/**
 * Utilities
 */
@NoException public static native @Cast("const char*") BytePointer pc_client_state_str(int state);
@NoException public static native @Cast("const char*") BytePointer pc_client_ev_str(int ev_type);
@NoException public static native @Cast("const char*") BytePointer pc_client_rc_str(int rc);

/**
 * set ca file for tls transports
 */

// #if !defined(PC_NO_UV_TCP_TRANS) && !defined(PC_NO_UV_TLS_TRANS)

/**
 * Sets the certificates that the client trust in order to verify the server for TLS communication.
 * Returns {@code PC_RC_OK} in case of success otherwise {@code PC_RC_ERROR}. For more information, see
 * https://www.openssl.org/docs/man1.0.2/ssl/SSL_CTX_load_verify_locations.html
 */
@NoException public static native int tr_uv_tls_set_ca_file(@Cast("const char*") BytePointer ca_file, @Cast("const char*") BytePointer ca_path);
@NoException public static native int tr_uv_tls_set_ca_file(String ca_file, String ca_path);

// #endif /* uv_tls */

/**
 * Macro implementation
 */
// #define pc_lib_version() PC_VERSION_NUM
// #define pc_lib_version_str() PC_VERSION_STR

// #ifdef __cplusplus
// #endif

// #endif /* PC_PITAYA_H */

}
