package dog.tale.pitaya;

import org.bytedeco.javacpp.*;

public class PitayaTest {
    static {
        System.load("/Users/arden/data/repository/tale/PitayaClientJava/lib/libpitaya-mac.bundle");
        //System.loadLibrary("Pitaya");
    }

    public static void main(String...args) {
        Object lock = new Object();

        try {


            Pitaya.pc_lib_set_default_log_level(Pitaya.PC_LOG_DEBUG);

            Pitaya.pc_lib_client_info_t clientInfo = new Pitaya.pc_lib_client_info_t();

            Pitaya.pc_lib_init((Pitaya.Pc_log_int_BytePointer) null, null, null, null, clientInfo);

            Pitaya.pc_client_config_t config = new Pitaya.pc_client_config_t();
            config.transport_name(Pitaya.PC_TR_NAME_UV_TCP);
            config.enable_reconn(1);
            config.conn_timeout(30);
            config.reconn_max_retry(Pitaya.PC_ALWAYS_RETRY);
            config.reconn_delay(30);


            Pitaya.pc_client_init_result_t result = Pitaya.pc_client_init(null, config);
            Pitaya.pc_client_t client = result.client();

            Pitaya.pc_client_connect(client, "tujiao.co", 3252, null);

            Pitaya.pc_client_add_ev_handler(client, new Pitaya.pc_event_cb_t() {
                @Override
                public void call(Pitaya.pc_client_t client, int ev_type, Pointer ex_data, BytePointer arg1, BytePointer arg2) {
                    System.out.println("aaa: " + ev_type);
                    if (ev_type == Pitaya.PC_EV_CONNECTED) {
                        Pitaya.pc_string_request_with_timeout(client, "room.join", null, null, 15, new Pitaya.pc_request_success_cb_t() {
                            @Override
                            public void call(Pitaya.pc_request_t req, Pitaya.pc_buf_t resp) {
                                System.out.println("request room.join succesed.");
                            }
                        }, new Pitaya.pc_request_error_cb_t() {
                            @Override
                            public void call(Pitaya.pc_request_t req, Pitaya.pc_error_t error) {

                            }
                        });

                        Pitaya.pc_string_notify_with_timeout(client, "room.message", "{\"name\":\"arden\", \"content\":\"welcome arden(他乐好棒)\"}", null, 15, new Pitaya.pc_notify_error_cb_t() {
                            @Override
                            public void call(Pitaya.pc_notify_t req, Pitaya.pc_error_t error) {
                                System.out.println(error);
                            }
                        });
                    }
                }
            }, null, null);


            Pitaya.pc_client_set_push_handler(client, new Pitaya.pc_push_handler_cb_t() {
                @Override
                public void call(Pitaya.pc_client_t client, BytePointer route, Pitaya.pc_buf_t payload) {
                    System.out.println(route.getString());
                    System.out.println(payload.base().getString());
                }
            });

            while (true) {
                synchronized (lock) {
                    System.out.println("2.无限期等待中...");
                    lock.wait();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
